public class Life {
    static boolean[][] grid = new boolean[5][5]; //where 5 is the size of the matrix: 5x5;

    public void setStatus(int x, int y, boolean status) {
        grid[x][y] = status;
    }

    public boolean getStatus(int x, int y) {
        return grid[x][y];
    }
}