private int[][] buildColumnMajorMatrix(int width, int height) {

    int[][] matrix = new int[width][height];
    int cellValue = 0;

    for(int rowIndex = 0 ; rowIndex < height ; rowIndex++) {
        for(int columnIndex = 0 ; columnIndex < width ; columnIndex++, cellValue++) {
            matrix[columnIndex][rowIndex] = cellValue;
        }
    }

    return matrix;
}