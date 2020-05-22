public static String trimToWidth(BigDecimal b, int width) {
    String str = "Invalid";
    int digits = digitsBeforePeriod(b);

    // -2 for period and 0
    if(digits <= width - 2) {
        // use width and (width - digits - 1) as precision (-1 for period)
        String format = "%" + width + "." + (width - digits - 1) + "f";
        // rounds half-up
        str = String.format(format, b);

        // trim trailing 0s, unless it's .0
        while(str.endsWith("0") && !str.endsWith(".0")) {
            str = str.substring(0, str.length()-1);
        }
    }

    // add spaces in front
    str = String.format("%" + width + "s", str);

    return str;
}

public static int digitsBeforePeriod(BigDecimal b) {
    int number = b.intValue();
    int radix = 10;
    int d = 1;
    while((number % radix) != number) {
        radix *= 10;
        ++d;
    }
    return d;
}

public static void main(String[] args) {
    double[] values = new double[] {
            12345.6789, 123, 0.12345678,
            1.5, 0.0045, 12, 123456, 1234567
    };

    BigDecimal[] bigs = new BigDecimal[values.length];

    for(int i = 0; i < bigs.length; ++i) {
        bigs[i] = new BigDecimal(values[i]);
        System.out.println(trimToWidth(bigs[i], 8));
    }

}