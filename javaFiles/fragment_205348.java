@Test
public void testAllValues() {
    testValue("1000", "1000");
    testValue("1.000,000", "1000");
    testValue("-1.000,000", "-1000");
    testValue("9,132", "9.132");
    testValue("1,000.00", null);
    testValue("30.10.2010", null);
    testValue("1,000.000,00", null);
}

private void testValue(String germanString, String usString) {
    BigDecimal germanDecimal = (BigDecimal) parse(germanString);
    if (usString != null) {
        BigDecimal usDecimal = new BigDecimal(usString);
        assertEquals("German " + germanString + " did not equal US " + usString, 0, germanDecimal.compareTo(usDecimal));
    } else {
        assertEquals("German " + germanString + " should not have been pareseable", null, germanDecimal);
    }
}

public BigDecimal parse(String s) {
    // Patch because parse doesn't enforce the number of digits between the
    // grouping character (dot).
    if (!Pattern.matches("[^.]*(\\.\\d{3})*[^.]*", s)) {
        return null;
    }

    DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(Locale.GERMANY);
    df.setParseBigDecimal(true);

    // Have to use the ParsePosition API or else it will silently stop
    // parsing even though some of the characters weren't part of the parsed
    // number.
    ParsePosition position = new ParsePosition(0);
    BigDecimal parsed = (BigDecimal) df.parse(s, position);

    // getErrorIndex() doesn't seem to accurately reflect errors, but
    // getIndex() does reflect how far we successfully parsed.
    if (position.getIndex() == s.length()) {
        return parsed;
    } else {
        return null;
    }
}