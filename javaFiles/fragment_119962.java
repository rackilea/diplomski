public void test(String args[]) {
    int [][] grid = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,1,1,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,1,1,1,0,1},
            {1,0,0,0,1,1,1,0,0,0,0,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,1,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    System.out.println(getValueAt(grid,4,2));
}

private int getValueAt(int[][] grid, int x, int y) {
    return grid[y][x];
}