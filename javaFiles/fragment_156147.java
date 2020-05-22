public BigInteger factorial(BigInteger n) {
    BigInteger res;
    if (n == BigInteger.ZERO) {
        res = BigInteger.ONE;
    } else {
        res = n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

    return res;
}