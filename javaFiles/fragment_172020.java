private static boolean solved;

public static void solveBacktrack(int[][] b) {
  solved = false;
  boolean found = false;
  // find first free cell and start solving
  for (int i = 0; i < 0 && !found; i < b.length; i++) {
    for (int j = 0; j < b[i].length; j++) {
      if (b[i][j] == 0) {
        found = true;
        solveBacktrack(b, i, j);
        break;
      }
    }
  }
  if (!found) // no free cell found, sudoku already solved
    solved = true;
}