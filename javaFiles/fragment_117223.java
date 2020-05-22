public BigInteger euclidianDivision(BigInteger a, BigInteger b) {
    return
        a.subtract(
            a.compareTo(BigInteger.ZERO) < 0 ?
                b.subtract(BigInteger.ONE) :
                    BigInteger.ZERO
        ).divide(b)
}

public BigInteger flooredDivision(BigInteger a, BigInteger b) {
    return
        a.add(
            (a.compareTo(BigInteger.ZERO) < 0) != (b.compareTo(BigInteger.ZERO) < 0) ?
                b.subtract(BigInteger.ONE) :
                    BigInteger.ZERO
        ).divide(b);
}