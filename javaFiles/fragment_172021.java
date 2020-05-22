private static void solveBacktrack(int[][] b, int row, int col) {
  for (int k = 1; k <= b.length; k++) {
    if (checkLegalMove(b, row, col, k)) {
      b[row][col] = k;
      // find next free space
      int nextRow = row, nextCol = col;
      while(nextRow < b.length && b[nextRow][nextCol] != 0) {
        if (nextCol + 1 == b[nextRow].length) {
          nextCol = 0;
          nextRow++;
        } else {
          nextCol++;
        }
      }
      if (nextRow == b.length) {
        solved = true;
        break;
      }
      solveBacktrack(b, nextRow, nextCol);
      if (!solved)
        b[row][col] = 0; // reset if not solved
      else
        break;
    }
  }
}