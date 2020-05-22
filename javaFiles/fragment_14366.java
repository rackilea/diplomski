public class Life {
    boolean[][] grid;

    public Life(int x, int y, boolean status) {
        grid = new boolean[5][5]; //where 5 is the size of the matrix: 5x5
        grid[x][y] = status;
    }
}