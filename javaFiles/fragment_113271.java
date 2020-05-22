public static int digitsBeforePeriod(BigDecimal b) {
    int number = b.intValue();
    int radix = 10;
    int digits = 1;
    while((number % radix) != number) {
        radix *= 10;
        ++digits;
    }
    return digits;
}