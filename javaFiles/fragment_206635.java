public class GridHandler {

    private static GridHandler[][] grid;
    private int i;
    private int j;
    private int value;

    public static void init(int[][] input) {
        int rowNumber = input.length;
        int columnNumber = input[0].length;
        grid = new GridHandler[rowNumber][columnNumber];
        for (int r = 0; r < rowNumber; r++) {
            for (c = 0; c < columnNumber; c++) {
                grid[r][c] = new GridHandler(r, c, input[r][c]);
            }
        }
    }

    public static GridHandler[][] getGrid() {
        return grid;
    }

    public GridHandler(int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.value = value;
        grid[i][j] = this;
    }

    public int getValue() {
        return value;
    }

    public void setValue(value) {
        this.value = value;
    }

    public int getLeftValue() throws ArrayIndexOutOfBoundsException {
        if (j == 0) {
            throw new ArrayIndexOutOfBoundsException("Left edge");
        }
        return grid[i][j - 1].getValue();
    }

    public int getUpValue() throws ArrayIndexOutOfBoundsException {
        if (i == 0) {
            throw new ArrayIndexOutOfBoundsException("Up edge");
        }
        return grid[i - 1][j].getValue();
    }

    public int getRightValue() throws ArrayIndexOutOfBoundsException {
        if (j == grid[0].length - 1) {
            throw new ArrayIndexOutOfBoundsException("Right edge");
        }
        return grid[i][j + 1].getValue();
    }
    public int getDownValue() throws ArrayIndexOutOfBoundsException {
        if (i == grid.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Down edge");
        }
        return grid[i + 1][j].getValue();
    }

}