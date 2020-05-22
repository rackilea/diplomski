public class Example {
    public static void main(String[] args) {
        int[][] b = 
            {
                {0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1}
            };

        rec(b, 0, 4);

        for (int[] row : b) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void rec(final int[][] grid, final int row, final int col) {
        if (grid[row][col] != 1) return;

        grid[row][col]++;

        if (row-1 >= 0) rec(grid, row-1, col);
        if (row+1 < grid.length) rec(grid, row+1, col);
        if (col-1 >= 0) rec(grid, row, col-1);
        if (col+1 < grid[0].length) rec(grid, row, col+1);
    }
}