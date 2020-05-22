public void explode(int row, int col) {
    if (board[row][col].mCount==0 && !board[row][col].isMine()) {
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {

                if (c == col && r == row) { // make sure it's
                    continue;               // not the current index
                }

                if ((r >= 0 && r < user.userRow)
                        && (c >= 0 && c < user.userCol)
                        && (!board[r][c].isExposed())) { // check if
                                                         // already shown
                    board[r][c].setExposed(true);

                    if(board[r][c].mCount == 0) {
                        explode(r,c);
                    }
                }
            }
        }
    }
}