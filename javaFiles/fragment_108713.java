private final static BigInteger TWO = BigInteger.valueOf(2);
private final static BigDecimal MINUS_ONE = new BigDecimal(-1);

public static BigDecimal toBigDecimal(String hex) {
    // handle leading sign
    BigDecimal sign = null;
    if (hex.startsWith("-")) {
        hex = hex.substring(1);
        sign = MINUS_ONE;
    } else if (hex.startsWith("+")) {
        hex = hex.substring(1);
    }

    // constant must start with 0x or 0X
    if (!(hex.startsWith("0x") || hex.startsWith("0X"))) {
        throw new IllegalArgumentException(
                "not a hexadecimal floating point constant");
    }
    hex = hex.substring(2);

    // ... and end in 'p' or 'P' and an exponent
    int p = hex.indexOf("p");
    if (p < 0) p = hex.indexOf("P");
    if (p < 0) {
        throw new IllegalArgumentException(
                "not a hexadecimal floating point constant");
    }
    String mantissa = hex.substring(0, p);
    String exponent = hex.substring(p+1);

    // find the hexadecimal point, if any
    int hexadecimalPoint = mantissa.indexOf(".");
    int hexadecimalPlaces = 0;
    if (hexadecimalPoint >= 0) {
        hexadecimalPlaces = mantissa.length() - 1 - hexadecimalPoint;
        mantissa = mantissa.substring(0, hexadecimalPoint) +
            mantissa.substring(hexadecimalPoint + 1);
    }

    // reduce the exponent by 4 for every hexadecimal place
    int binaryExponent = Integer.valueOf(exponent) - (hexadecimalPlaces * 4);
    boolean positive = true;
    if (binaryExponent < 0) {
        binaryExponent = -binaryExponent;
        positive = false;
    }

    BigDecimal base = new BigDecimal(new BigInteger(mantissa, 16));
    BigDecimal factor = new BigDecimal(TWO.pow(binaryExponent));
    BigDecimal value = positive? base.multiply(factor) : base.divide(factor);
    if (sign != null) value = value.multiply(sign);

    return value;
}