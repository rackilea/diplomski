static char[][] createBoard(int x, int y) {
    char[][] board = new char[x][y];
    for (char[] row : board) {
        Arrays.fill(row, ' ');
    }
    return board;
}