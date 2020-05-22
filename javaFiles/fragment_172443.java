public static int rowSum(int[][] counts, int row) {
    int sum = 0;
    for (int count : counts[row]) {
        sum += count;
    }
    return sum;
}