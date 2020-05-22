public BigFraction(BigDecimal d)
{
    this(computeNumerator(d), computeDenominator(d));
}

private static BigInteger computeNumerator(BigDecimal d) { ... }
private static BigInteger computeDenominator(BigDecimal d) { ... }