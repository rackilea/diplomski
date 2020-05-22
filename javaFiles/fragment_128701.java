public BigInteger factorial(int n) {
    if (n == 0) {
        return BigInteger.ONE;
    } else {
        return new BigInteger(n) * factorial(n - 1);
    }
}