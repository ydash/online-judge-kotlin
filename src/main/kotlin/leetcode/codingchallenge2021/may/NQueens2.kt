package leetcode.codingchallenge2021.may

object NQueens2 {
    fun totalNQueens(n: Int): Int {
        var count = 0
        val occupiedRightDiag = BooleanArray(n * 2 - 1)
        val occupiedLeftDiag = BooleanArray(n * 2 - 1)
        val occupidRow = BooleanArray(n)

        fun backtracking(col: Int) {
            (0 until n).forEach loop@{ row ->
                val leftDiag = col + row
                val rightDiag = n - col + row - 1
                if (occupidRow[row] || occupiedLeftDiag[leftDiag] || occupiedRightDiag[rightDiag]) return@loop
                if (col == n - 1) {
                    count++
                } else {
                    occupidRow[row] = true
                    occupiedLeftDiag[leftDiag] = true
                    occupiedRightDiag[rightDiag] = true
                    backtracking(col + 1)
                    occupidRow[row] = false
                    occupiedLeftDiag[leftDiag] = false
                    occupiedRightDiag[rightDiag] = false
                }
            }
        }

        backtracking(0)
        return count
    }
}
