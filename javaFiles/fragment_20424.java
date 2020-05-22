public static void main(String s[]) {
    getDoubleFromStringWithPercent("12345%");
}

private static Double getDoubleFromStringWithPercent(String string) {
    Locale locale = Locale.CANADA;
    Double num = null;
    try {
        Number number = NumberFormat.getPercentInstance(locale).parse(string);
        if (number instanceof Long) {
            num = ((Long) number).doubleValue();
        } else {
            num = (Double) number;

        }
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }
    return num;
}