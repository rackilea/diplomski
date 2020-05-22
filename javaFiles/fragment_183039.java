boolean isValidRangeNumber(Double no, int precision, int scale) {
    BigDecimal bigDecimal = new BigDecimal(no.toString()).stripTrailingZeros(); //Get rid of trailing zeros
    bigDecimal.toPlainString();
    int intPartLength = precision - scale;

    int size = (bigDecimal.longValue() + "").toString().length();

    if (bigDecimal.precision() <= precision && bigDecimal.scale() <= scale
            && size <= intPartLength)
        return true;

    return false;
}