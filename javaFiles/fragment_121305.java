public int product(int n) {
    if (n < 1) {
        throw new IllegalArgumentException("n must be 1 or greater");
    }

    int result = 1;
    for (int i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}