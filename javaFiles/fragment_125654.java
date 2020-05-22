public class Grid {
    private int[][] myGrid;
    private int x, y;

    public Grid(int x, int y) {
        myGrid = new int[y][x];
    }

    public int getRowCount() {
        return myGrid.length;
    }

    public int getColumnCount() {
        return myGrid[0].length;
    }
}