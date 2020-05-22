public static Profit bestProfit(int[] a, int begin, int end) {
    Profit bestProfit = new Profit();
    int min = a[begin];
    int max = a[begin];
    int index = begin;
    int buy = 0;
    int sell = 0;
    int minIndex = begin;
    int maxIndex;
    int maxProfit = 0;
    for (int i = begin; i < end; i++) {
        int n = a[i];
        if (n < min) {
            minIndex = index;
            min = n;
            max = n;
        } else if (max < n) {
            max = n;
            maxIndex = index;
            if (maxProfit < (max - min)) {
                maxProfit = max - min;
                buy = minIndex;
                sell = maxIndex;
            }
        }
        index++;
    }
    bestProfit.setBuy(buy);
    bestProfit.setSell(sell);
    bestProfit.setMaxProfit(maxProfit);
    return bestProfit;
}