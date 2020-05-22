private boolean checkRowsEquality(int[][] matrix, int row, int col) {
    for (int i = 0; i < matrix.length; i++) {
           if (matrix[row][i] != matrix[i][col])
               return false;
    }
    return true;
}


private boolean checkEquality(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            if (checkEquality(matrix, i, j)) 
               return true;
        }
    }
    return false;
}