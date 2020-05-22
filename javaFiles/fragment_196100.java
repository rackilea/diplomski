public double maxProfit(double[] prices) {

    if (prices.length <= 1) return 0;

    double minPrice = prices[0];
    double maxSoFar = Integer.MIN_VALUE;
    double profitSoFar = Integer.MIN_VALUE;

    for (int i = 1; i < prices.length; i++){
        profitSoFar = prices[i] - minPrice;
        minPrice = Math.min(minPrice, prices[i]);
        maxSoFar = Math.max(profitSoFar, maxSoFar);

    }

    return Math.max(maxSoFar, 0);
}