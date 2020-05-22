public static void main(final String[] args) {
    check(truncate("12.000000"), "12");
    check(truncate("12.0001"), "12");
    check(truncate("12.0051"), "12.01");
    check(truncate("12.99"), "12.99");
    check(truncate("12.999"), "13");
    check(truncate("12.3456"), "12.35");
    System.out.println("if we see this message without exceptions, everything is ok");
}

private static BigDecimal truncate(final String text) {
    BigDecimal bigDecimal = new BigDecimal(text);
    if (bigDecimal.scale() > 2)
        bigDecimal = new BigDecimal(text).setScale(2, RoundingMode.HALF_UP);
    return bigDecimal.stripTrailingZeros();
}

private static void check(final BigDecimal bigDecimal, final String string) {
    if (!bigDecimal.toString().equals(string))
        throw new IllegalStateException("not equal: " + bigDecimal + " and " + string);

}