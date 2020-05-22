public static void print() {
    String row = "";
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == 0) {
                row += "-";
            } else  {
                row += (char) (board[i][j]);
            }
            if (j == board[i].length - 1) {
               Terminal.printLine(row);
               row = "";
            }
        }
    }
}