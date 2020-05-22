private static final BigInteger BI_2_64 = BigInteger.ONE.shiftLeft(64);

public static String asString(long l) {
    return l >= 0 ? String.valueOf(l) : toBigInteger(l).toString();
}

public static BigInteger toBigInteger(long l) {
    final BigInteger bi = BigInteger.valueOf(l);
    return l >= 0 ? bi : bi.add(BI_2_64);
}