/** 
 * Counts pieces of the given type, starting at (y, x), 
 * in the direction denoted by (dy, dx).
 * Stops at field boundaries or when a different field type is encountered. 
 */
int count(char type, int x, int y, int dx, int dy) {
  int count = 0;
  x += dx;  // Skip the piece at (y, x) to avoid counting it twice
  y += dy;  // when looking in both directions on a line.
  while (x >= 0 && x < 7 && y >= 0 && y < 6 && board[x][y] == type) {
    count++;
    x += dx;  // Move in the direction denoted by (dy, dx)
    y += dy;
  }
  return count;
} 

/**
 * Main entry point after a new piece of type `type` was added at (y, x). 
 * Returns true if this connects 4 or more in any direction.
 */
boolean check(char type, int x, int y) {
  return count(type, x, y, -1, 0) + 1 + count(type, x, y, 1, 0) >= 4  // horizontal
      || count(type, x, y, 0, -1) + 1 + count(type, x, y, 0, 1) >= 4  // vertical
      || count(type, x, y, -1, -1) + 1 + count(type, x, y, 1, 1) >= 4  // diagonal
      || count(type, x, y, -1, 1) + 1 + count(type, x, y, 1, -1) >= 4);
}