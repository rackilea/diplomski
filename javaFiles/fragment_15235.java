public static int computeSum(int start, int end) {
    return sumN(end) - sumN(start);
}

private static int sumN(int n) {
    return ((n + 2) * (n + 1)) / 2;
}