public static void enumerate(int[][] board, int row, int col) {
    int boardSize = board.length;
    if (col == boardSize ) {
        System.out.println();
        print(board);
        SaveToFile.saveSquare("Latin", "BT", board, boardSize);

    }
    else {
        for (int i = 1; i <= boardSize; i++) {
            board[row][col] = i;
            if (isSafe(board, row, col)) {
                if(row+1 == boardSize) {
                    enumerate(board, 0, col+1);
                }
                else {
                    enumerate(board, row+1, col);
                }
            }
            //RESET!!!
            board[row][col] = 0;
        }
    }
}