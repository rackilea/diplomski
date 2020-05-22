public static double roundToPrecision(double number, double roundPrecision)
{
    BigDecimal numberBig = new BigDecimal(number).
            setScale(10, BigDecimal.ROUND_HALF_UP);
    BigDecimal roundPrecisionBig = BigDecimal.valueOf(roundPrecision);
    if (roundPrecisionBig.signum() == 0)
        return number;
    BigDecimal numberDecimalMultiplier = numberBig.divide(roundPrecisionBig, RoundingMode.HALF_DOWN).setScale(0, RoundingMode.HALF_UP);
    return numberDecimalMultiplier.multiply(roundPrecisionBig).doubleValue();
}