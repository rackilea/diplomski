public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
    int[][] result = new int[matrixA.length][matrixB[0].length];

    for (int i = 0; i < result.length; i++) {
        for (int j = 0; j < result[0].length; j++) {
            for (int k = 0; k < matrixB.length; k++) {
                result[i][j] += matrixA[i][k] * matrixB[k][j];
            }
        }
    }
    return result;
}