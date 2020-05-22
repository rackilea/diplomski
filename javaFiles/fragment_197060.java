int[][] chessboard = new int[8][8]; // here all values are 0 as it's an int array
for (int i = 0; i < chessboard.length; i++) {
    for (int j = 0; j < chessboard.length; j++) {
        chessboard[i][j] = j;
    }
}