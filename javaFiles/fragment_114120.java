public void run() {
    int i, j, k;
    for (i = 0; i < matA.length; i++) {
        for (j = 0; j < matA.length; j++) {
            for (k = 0; k < matA.length; k++) {
                matC[i][j] += matA[i][k] * matB[k][j];
            }
        }
    }
}