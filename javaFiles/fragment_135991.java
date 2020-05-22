private int[][] buildRowMajorMatrix(int width, int height) {

    int[][] matrix = new int[width][height];
    int cellValue = 0;

    for(int columnIndex = 0 ; columnIndex < width ; columnIndex++) {
        for(int rowIndex = 0 ; rowIndex < height ; rowIndex++, cellValue++) {
            matrix[columnIndex][rowIndex] = cellValue;
        }
    }

    return matrix;
}