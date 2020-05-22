public static BigDecimal pow(BigDecimal x, BigDecimal y)
{
    BigDecimal val = BigFunctions.ln(x, 33).setScale(32, RoundingMode.HALF_UP).multiply(y);
    BigDecimal result = BigFunctions.exp(val, 33).setScale(32, RoundingMode.HALF_UP);
    return result;
}