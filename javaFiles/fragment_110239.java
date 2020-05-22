public static void printBoard(char[][] board) {
    String ab = "ABCDEFGHIJ";
    System.out.println("    1 2 3 4 5 6 7 8 9");
    for (int row = 0; row < board.length; row++) {
        System.out.print(ab.charAt(row) + " |"); // <-- not a newline.
        for (char ch : board[row]) {
            System.out.printf("%c ", ch);
        }
        System.out.println(); // <-- done with the current line.
    }
}