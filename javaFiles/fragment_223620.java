public static int largestDivisor(int n) {
    for (int i = n / 2; i >= 2; i--) {
        if (n % i == 0) {
            return i;
        }
    }
    return 1;
}