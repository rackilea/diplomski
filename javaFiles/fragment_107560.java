enum Side { Left, Right, Top, Bottom };

public boolean[][] expandMatrixBy(boolean[][] matrix, int number, Set<Side> sides) {
  int oldSize = matrix.length;
  int newSize = oldSize + number * sides.size();
  boolean[][] result = new boolean[newSize][newSize];

  for (Side side : sides) {
    switch(side) {
      case Left:
        // Add number of columns on the left.

      case Right:
        // Add "number" of columns on the right.
    }
  }
  return result;
}

Set<Side> expandOnTheseSides = EnumSet.of(Side.Left, Side.Top);
gameBoard = expandMatrixBy(gameBoard, 1, expandOnTheseSides);