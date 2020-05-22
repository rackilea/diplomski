public static BigDecimal parseCurrencyPrecise (String value)
{
    NumberFormat  format = NumberFormat.getCurrencyInstance ();
    if (format instanceof DecimalFormat)
        ((DecimalFormat) format).setParseBigDecimal (true);

    Number  result = format.parse (value);
    if (result instanceof BigDecimal)
        return (BigDecimal) result;
    else {
        // Oh well...
        return new BigDecimal (result.doubleValue ());
    }
}