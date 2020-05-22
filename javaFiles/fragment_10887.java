// instead of: board[i-1][j-1]

public String getBoardValue(int x, int y) {
  if (x<0 || x>=boardSize) return "";
  if (y<0 || y>=boardSize) return "";
  return board[x][y];
}