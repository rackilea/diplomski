public static int [][] add(int[][]a, int[][]b) {
    int[][] r = new int [3][3];
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            r[i][j] = a[i][j] + b[i][j];
        }
    }
    return r;
}