int addUp(int[][] matrix, int N, int diag) {
    int sum = 0;
    for (int row = 0 ; row != N ; row++) {
        for (int col = 0 ; col != N ; col++) {
            int d = col-row;
            if (d >= diag || d <= -diag) {
                sum += matrix[row][col];
            }
        }
    }
    return sum;
}