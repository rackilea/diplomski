public boolean findPath(int row, int col) {
  board[row][col].visit();

  if ((col == 7) && (row == 7)) {
    board[row][col].selectCell();
    return true;
  }

  if ((row < 7) && !board[row + 1][col].marked() &&
      !board[row + 1][col].blocked() && !board[row + 1][col].visited()) {
    block(row, col);

    if (findPath(row + 1, col)) {
      board[row][col].selectCell();
      return true;
    }

    unblock(row, col);
  }

  if ((col > 0) && !board[row][col - 1].marked() &&
      !board[row][col - 1].blocked() && !board[row][col - 1].visited()) {
    block(row,col);

    if (findPath(row, col - 1)) {
      board[row][col].selectCell();
      return true;
    }

    unblock(row,col);
  }

  if ((col < 7) && !board[row][col + 1].marked() &&
      !board[row][col + 1].blocked() && !board[row][col + 1].visited()) {
    block(row,col);

    if (findPath(row, col + 1)) {
      board[row][col].selectCell();
      return true;
    }

    unblock(row,col);
  }
  if ((row > 0) && !board[row - 1][col].marked() &&
      !board[row - 1][col].blocked() && !board[row - 1][col].visited()) {
    block(row, col);

    if (findPath(row - 1, col)) {
      board[row][col].selectCell();
      return true;
    }

    unblock(row, col);
  }

  return false;
}