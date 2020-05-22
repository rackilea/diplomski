public void floodFill(int[][] pic, int row, int col, int oldC, int newC) {

  // Base Cases
  if(row < 0 || col < 0 || row >= pic.length || col >= pic[row].length) {
     return;
  }
  if(pic[row][col] != oldC) {
     return;
  }

  pic[row][col] = newC;

  // recursion
  floodFill(pic, row + 1, col, oldC, newC);
  floodFill(pic, row - 1, col, oldC, newC);
  floodFill(pic, row, col + 1, oldC, newC);
  floodFill(pic, row, col - 1, oldC, newC);
}