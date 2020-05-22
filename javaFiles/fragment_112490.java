public int minChange(int[] denom, int targetAmount) {

    int actualAmount;
    int m = denom.length+1;
    int n = targetAmount + 1;
    int inf = Integer.MAX_VALUE-1;

    int[][] table = new int[m][n];
    for (int j = 1; j < n; j++)
        table[0][j] = inf;

    for (int denomPosition = 1; denomPosition < m; denomPosition++) {
        for (int currentAmount = 1; currentAmount < n; currentAmount++) {
            if (currentAmount - denom[denomPosition-1] >= 0)
                actualAmount = table[denomPosition][currentAmount - denom[denomPosition-1]];
            else
                actualAmount = inf;
            table[denomPosition][currentAmount] = Math.min(table[denomPosition-1][currentAmount], 1 + actualAmount);
        }
    }

    return table[m-1][n-1];

}