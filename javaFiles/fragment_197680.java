public static int divideAndConquer(int[] a, int i, int j, Profit profit, int min) {
    int minResult;
    if (i+1 >= j) {
        minResult = Math.min(a[i], min);
        if (a[i] - min > profit.getMaxProfit()) {
            profit.setBuy(min);
            profit.setSell(a[i]);
            profit.setMaxProfit(a[i] - min);
        }
    } else {
        int n = (j+i)/2;
        minResult = divideAndConquer(a, i, n, profit, min);
        minResult = divideAndConquer(a, n, j, profit, minResult);
    }
    return minResult;
}

public static void main(String[] args) {
    int[] prices = {20, 31, 5, 7, 3, 4, 5, 6, 4, 0, 8, 7, 7, 4, 1,10};
    Profit profit =new Profit();
    divideAndConquer(prices, 0, prices.length, profit, Integer.MAX_VALUE);
    System.out.println(profit);
}