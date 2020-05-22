private static void duplicateAlternates(int[][] matrix) {
    for (int row = 0; row < matrix.length; row += 2)
        for (int col = 1; col < matrix.length; col += 2)
            matrix[row][col] = matrix[row][col - 1];
    for (int row = 1; row < matrix.length; row += 2)
        for (int col = 0; col < matrix.length; col++)
            matrix[row][col] = matrix[row - 1][col];
}