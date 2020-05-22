public static void main(String... args) {
    int[][] bino = new int[15][]; //Create 2d array for pascal pyramid
    for (int i = 0; i < bino.length; i++) {
        bino[i] = new int[i + 1];
        for (int j = 0; j < i + 1; j++) {
            bino[i][j] = nOverk(i, j);
        }
    }
}

static int nOverk(int n, int k) {
    int min = Math.min(k, n - k);
    int max = Math.max(k, n - k);
    return fac(n, max) / fac(min, 1);
}

static int fac(int hi, int lo) {
    if (hi == 0 || hi == 1)
        return 1;

    int res = 1;
    for (int i = lo + 1; i <= hi; i++)
        res *= i;
    return res;
}