private static double binaryStringToDouble(String s) {
    return stringToDouble(s, 2);
}

private static double stringToDouble(String s, int base) {
    String withoutPeriod = s.replace(".", "");
    double value = new BigInteger(withoutPeriod, base).doubleValue();
    String binaryDivisor = "1" + s.split("\\.")[1].replace("1", "0");
    double divisor = new BigInteger(binaryDivisor, base).doubleValue();
    return value / divisor;
}

@Test
public void test_one_point_5() {
    String s = "1.1";
    double d = binaryStringToDouble(s);
    assertEquals(1.5, d, 0.0001);
}

@Test
public void test_6_8125() {
    String s = "110.1101";
    double d = binaryStringToDouble(s);
    assertEquals(6.8125, d, 0.0001);
}

@Test
public void test_yours() {
    String s = "1.1010000111110000000000000000000000000000000000000000";
    double d = binaryStringToDouble(s);
    assertEquals(1.632568359375, d, 0.000000000000000001);
}

@Test
public void test_yours_no_trailing_zeros() {
    String s = "1.101000011111";
    double d = binaryStringToDouble(s);
    assertEquals(1.632568359375, d, 0.000000000000000001);
}