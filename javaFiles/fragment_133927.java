int[][] board; // row tiles for ultimate mapping experience!

private static int BLOCKED = 24;

public boolean blocked(int tx, int ty) {
  return board[ty][tx] == BLOCKED;
}