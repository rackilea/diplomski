static int findNQueensSolutions(int N, int curRow, int[][] board) {
    if (curRow == N)
        return 1; // found 1 position

    int result = 0; // found 0 positions yet
    for (int curCol = 0; curCol < N; curCol++)
        if (validPosition(board, curRow, curCol, N)) {
            board[curRow][curCol] = 1;
            result += findNQueensSolutions(N, curRow + 1, board); // do not return immediately, maybe there are more?
            board[curRow][curCol] = 0;
        }
    return result;
}