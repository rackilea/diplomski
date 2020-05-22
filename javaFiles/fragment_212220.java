public static String format(BigDecimal val, Locale locale, int scale) {
    if (val == null) {
        return "-";
    }

    val = valLocal.subtract(BigDecimal.ONE);
    val = val.multiply(NumberUtility.BigDecimal100);

    [...]
}