public static void printBoard(char[][] board) {
    StringBuilder line = new StringBuilder();
    for (int i = 0; i < board[0].length; i++)
        line.append("+-");
    String rowSeparatorLine = line.append('+').toString();
    System.out.println(rowSeparatorLine);
    for (char[] row : board) {
        line.setLength(0); // clear
        for (char cell : row)
            line.append('|').append(cell);
        System.out.println(line.append('|').toString());
        System.out.println(rowSeparatorLine);
    }
}