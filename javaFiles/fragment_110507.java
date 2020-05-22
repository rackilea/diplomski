Iterator<Integer> i = list.iterator();

for (int row = 0; row < 4; row++) {
  for (int column = 0; column < 6; column++) {
    int type = i.next();
    board[row][column] = new Cell(this, type, row, column);
  }
}