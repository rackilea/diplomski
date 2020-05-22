public static BigDecimal roundToPrecision(BigDecimal number, BigDecimal roundPrecision) {
    if (roundPrecision.signum() == 0)
        return number;
    BigDecimal numberDecimalMultiplier = number.divide(roundPrecision, RoundingMode.HALF_DOWN).setScale(0, RoundingMode.HALF_UP);
    return numberDecimalMultiplier.multiply(roundPrecision);
}


BigDecimal n = new BigDecimal("-8.7250");
BigDecimal p = new BigDecimal("0.05");
BigDecimal r = roundToPrecision(n, p);