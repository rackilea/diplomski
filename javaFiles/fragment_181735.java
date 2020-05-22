int[][] chessBoard = new int[3][4];
    int rowhead = 1;
    TextIO.put("  ");
    for (int col = 0; col < chessBoard[0].length; col++)
        TextIO.putf("%4s",((char) ('A' + col)));
    TextIO.putln();

    for (int [] row:chessBoard) {
        TextIO.put(rowhead++ + ":");
        chessBoard[2][3] = 1;
        for (int griddisplay : row){
            TextIO.putf("%4d", griddisplay);
        }
        TextIO.putln();
    }