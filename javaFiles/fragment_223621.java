public static int largestDivisor(int n) {
    if (n % 2 == 0) {
        return n / 2;
    }
    final int sqrtn = (int) Math.sqrt(n);
    for (int i = 3; i <= sqrtn; i += 2) {
        if (n % i == 0) {
            return n / i;
        }
    }
    return 1;
}