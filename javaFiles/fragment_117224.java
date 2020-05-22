public BigInteger flooredRemainder(BigInteger a, BigInteger b) {
    return
        a.mod(b).subtract(
            b.compareTo(BigInteger.ZERO) < 0 ? BigInteger.ONE : BigInteger.ZERO
        );
}