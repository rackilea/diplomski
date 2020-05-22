private static int biggestEvenNum(int[] x) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < x.length; i++) {
        if (x[i] % 2 == 0) {
            max = Math.max(max, x[i]);
        }
    }
    return max;
}