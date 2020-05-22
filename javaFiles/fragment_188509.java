int offset = 0;
for (int i=0; i < row; i++) {
    for (int j=0; j < column; j++) {
        boardArray[i][j] = startConfig.charAt(offset++);
        System.out.println(boardArray[i][j]);
    }
}