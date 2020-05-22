if ((board[row][col].equals(board[row + 1][col]))
    && (board[row][col].equals(board[row + 2][col]))
    && (board[row][col].equals(board[row + 3][col]))
    && (!board[row][col].equals("| |"))) {
    winVerticalCheck = true;
}