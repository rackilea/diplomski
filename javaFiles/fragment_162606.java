static double generateSigmaSequnce(int n) {
    if (n < 1) { return 0; }
    double sum = 0;
    for (int i = 1; i <= n; i++) {
        sum += (generateSigmaSequnce(n - i) - 1) / factorial(i);
    }
    return sum;