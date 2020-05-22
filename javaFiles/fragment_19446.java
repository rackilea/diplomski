public static int coinChangeGreedy(int[] coins, int n) {

        int result = 0;

        while (n != 0) {

            for (int i=coins.length - 1 ; i>=0 ; i--) {
                if (coins[i] <= n) {
                    n = n - coins[i];
                  System.out.println("Adding " +coins[i]);
                  i++; //neutralizing i-- with i++.

                    result++;
                }
            }
        }
        return result;
    }