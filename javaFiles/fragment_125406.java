public static int factorial(final int n) {
    if (n <= 1) {
        return 1;
    }
    return n * factorial(n - 1);
}