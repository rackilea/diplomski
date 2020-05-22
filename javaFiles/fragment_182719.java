public static boolean canSplit(int[] array) {
    int total = IntStream.of(array).sum();
    int sum = 0;
    for (int i : array) {
        sum += i;
        if (sum == total - sum) return true;
    }
    return false;
}