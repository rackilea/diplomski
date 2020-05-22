...
    // Final Logic from here...
    System.out.println("\nOut Matrix:\n");
    int[] outputRow = new int[col];
    print(0, row, col, first, outputRow);

}

private static void print(int j, int row, int col, int[][] first, int[] outputRow) {
    for (int i = 0; i < row; i++) {
        outputRow[j] = first[i][j];
        // recursively continue to populate outputRow until we reach the last column (j == col -1)
        if (j < col - 1) {
            print(j + 1, row, col, first, outputRow);               
        }
        // we have reached the last column (j == col -1) so now we could print current permutation
        if (j == col - 1) {
            for (int k = 0; k < col; k++) {
                System.out.print(" " + outputRow[k]);                   
            }
            System.out.println();                   
        }
    }
}