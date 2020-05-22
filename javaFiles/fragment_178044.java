public static long coinSum(int euro) {
    double[] coins = { 0, 0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1, 2 };
    long[][] numberoftimes = new long[coins.length][];

    for (int i = 0; i < coins.length; i++) {
        numberoftimes[i] = new long[euro + 1];
        for (int j = 0; j <= euro; j++) {
            if (i == 0 && j == 0) {
                numberoftimes[i][j] = 1;
            } else if (i < j) {
                numberoftimes[i][j] = numberoftimes[i - 1][j] + numberoftimes[i][j - i];
            } else {
                numberoftimes[i][j] = numberoftimes[i - 1][j];
            }
        }
    }
    return numberoftimes[coins.length - 1][euro];
}