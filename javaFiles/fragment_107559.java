boolean[][] gameBoard = new boolean[3][3];

public boolean[][] expandMatrixBy(boolean[][] matrix, int number) {
  int oldSize = matrix.length;
  int newSize = oldSize + 2 * number;
  boolean[][] result = new boolean[newSize][newSize];

  // Assume new cells should be dead, i.e. false..
  for (int row = number; row < oldSize + number; row++) {
    for (int col = number; col < oldSize + number; col++) {
      // ..copy only the existing cells into new locations.
      result[row][col] = matrix[row - number][col - number];
    }
  }
  return result;
}

// Calling this on a 3x3 matrix will produce 5x5 matrix, expanded by 1 on each side.
gameBoard = expandMatrixBy(gameBoard, 1);