boolean checkHorizontal(String[][] board) {
    final String emptyCell = "[ ]";

    for (int row = 0; row < board.length; row++) {
        String firstElementInRow = board[row][0];
        if (firstElementInRow.equals(emptyCell)) {
            continue;
        }
        int column;
        for (column=1; column < board[row].length; column++) {
            if (!board[row][column].equals(firstElementInRow)) {
                break;
            }
        }
        if (column==board[row].length) {
            return true;
        }
    }
    return false;
}