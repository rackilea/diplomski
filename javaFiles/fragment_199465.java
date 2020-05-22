static void sumToValueCount(int limit, int sum, int count) {
    int dp[][][] = new int[limit + 1][sum + 1][count + 1];
    for (int i = 0; i <= limit; i++) {
        for (int j = 0; j <= sum; j++) {
            for (int k = 0; k <= count; k++) {
                if (j == 0 && k == 0) {
                    dp[i][j][k] = 1;
                } else if (i == 0 || j <= 0 || k == 0) {
                    dp[i][j][k] = 0;
                } else {
                    // check to prevent negative index
                    if (j - i >= 0) {
                        // two options: choose the number or not choose the number
                        dp[i][j][k] = dp[i - 1][j - i][k - 1] + dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
    }
    System.out.println(dp[limit][sum][count]);
}