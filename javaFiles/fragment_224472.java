public BigInteger binom(int n, int k) {
        return (k == 0 || n == k) ? BigInteger.ONE : faculty(n).divide((faculty(k).multiple(faculty(n - k)));
    }

private BigInteger faculty(int n) {
    BigInteger result = BigInteger.ONE;
    while (!n.equals(BigInteger.ZERO)) {
        result = result.multiply(n);
        n = n.subtract(BigInteger.ONE);
    }
    return result;
}

public void printPascal(boolean upsideDown) {
    if (n == 0) { return; }
    for (int j = 0; j <= n; j++) {
        for (int i = 0; i < j; i++) {
            System.out.print(binom(j - 1, i).toString() + (j == i + 1 ? "\n" : " "));
        }
    }
}