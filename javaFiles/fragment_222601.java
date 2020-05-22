package gameOfLife;

public class Grid {
    protected int[][] grid;

    public Grid(int x, int y) {
        grid = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                grid[i][j] = 0;
            }
        }
    }

    public int nuggets(int x, int y) {
        return grid[x][y];
    }

    public void setAt(int column, int row, int alive) {
        grid[column][row] = alive;
    }

}