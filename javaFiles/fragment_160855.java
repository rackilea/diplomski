public static int[] getColumn(final int[][] grid, final int j) {
    final int index = j - 1; // if we search for 1st element his index is 0, 2nd -> 1, etc.
    final int[] result = new int[grid.length];
    for (int i = 0; i < grid.length; i++) {
        result[i] = grid[i][index]; // take from each sub-array the index we're interesting in
    }
    return result;
}