public Grid copyGrid (Grid grid) {
  Grid newGrid = new Grid(height, width);
  for (int row = 0; row < height; row++) {
    for (int col = 0; col < width; col++) {
      newGrid.getArray()[row][col] = grid.getArray()[row][col];
    }
  }
  return newGrid;
}