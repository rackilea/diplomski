List<Integer> list = new ArrayList<Integer>(24);

for (int type = 1; type <= 12; type++) {
  //Add each type twice
  list.add(type);
  list.add(type);
}

Collections.shuffle(list);
int[][] board = new int[4][6];

for (int row = 0; row < 4; row++) {
  for (int column = 0; column < 6; column++) {
    int type = list.get(row + column * 4);
    board[row][column] = new Cell(this, type, row, column);
  }
}