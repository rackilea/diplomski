int offset = 0;
for (int i=0; i < row; i++) {
    for (int j=0; j < column; j++) {
        boardArray[i][j] = startConfig.charAt(offset++);
        System.out.print(boardArray[i][j]);
    }
    System.out.println ();
    // uncomment below line if you want a blank line
    // System.out.println ();
}