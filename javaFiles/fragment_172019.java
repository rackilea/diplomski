public static boolean checkLegalMove(int[][] b, int row, int col, int num) {
  if (b[row][col] != 0) // occupied
    return false;
  // check row
  for (int i = 0; i < b[row].length; i++) {
    if (b[row][i] == num)
      return false;
  }
  // check column
  for (int i = 0; i < b.length; i++) {
    if (b[i][col] == num)
      return false;
  }
  // check box with some integer math
  for (int i = row / 3 * 3; i < (row / 3 + 1) * 3; i++) {
    if (i == row) // row already checked
      continue;
    for (int j = col / 3 * 3; j < (col / 3 + 1) * 3; j++) {
      if (j == col) // column already checked
        continue;
      if (b[i][j] == num)
        return false;
    }
  }
  return true;
}