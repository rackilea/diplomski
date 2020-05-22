boolean[][]grid2;
 public WorldState(boolean[][] grid, int row, int col)
 {
    int gridRow = grid.length;
    int gridCol = grid[0].length;

    grid2 = new boolean[gridRow][gridCol];

    for (int i = 0; i < gridRow; i++) {
        for (int j = 0; j < gridCol; j++){
            grid2[i][j] = grid[i][j];
        }
    }
    grid2[row][col] = true;
 }