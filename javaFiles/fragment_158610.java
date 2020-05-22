public class FindConsecutiveNumbersInGrid {

public static int[][] grid = new int[][]{
    {2, 5, 1, 0, 8, 0, 8},
    {2, 1, 0, 9, 7, 2, 4},
    {3, 3, 3, 3, 4, 6, 7},
    {1, 0, 3, 4, 7, 4, 9},
    {3, 3, 3, 2, 3, 1, 6},
    {9, 7, 4, 1, 8, 4, 6}
};

public static void main(String[] args) {
    int maxFound = 0;
    int[] maxFoundPos = new int[2];
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            boolean[][] foundGrid = new boolean[grid.length][grid[0].length];
            findConsecutive(i, j, foundGrid);
            int found = getFound(foundGrid);
            if (found > maxFound) {
                maxFound = found;
                maxFoundPos[0] = i;
                maxFoundPos[1] = j;
            }
        }
    }
    System.out.println(maxFoundPos[0] + " " + maxFoundPos[1]);
}

public static void findConsecutive(int i, int j, boolean[][] foundGrid) {
    foundGrid[i][j] = true;
    if (i < grid.length - 1 && grid[i][j] == grid[i+1][j] && !foundGrid[i+1][j]) {
        findConsecutive(i+1, j, foundGrid);
    }
    if (i > 0 && grid[i][j] == grid[i-1][j] && !foundGrid[i-1][j]) {
        findConsecutive(i-1, j, foundGrid);
    }
    if (j < grid[i].length - 1 && grid[i][j] == grid[i][j+1] && !foundGrid[i][j+1]) {
        findConsecutive(i, j+1, foundGrid);
    }
    if (j > 0 && grid[i][j] == grid[i][j-1] && !foundGrid[i][j-1]) {
        findConsecutive(i, j-1, foundGrid);
    }
}

public static int getFound(boolean[][] foundGrid) {
    int found = 0;
    for (boolean[] foundRow : foundGrid) {
        for (boolean foundSpace : foundRow) {
            if (foundSpace) found++;
        }
    }
    return found;
}