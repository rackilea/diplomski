public static void main(String... args) {
    BigInteger bi = BigInteger.valueOf(11).pow(48100);
    System.out.println(bi.toString());
    System.out.println(toString(bi));
    System.out.println("bi.length=" + bi.toString().length() + ", toString(bi).length=" + toString(bi).length());
    for (int i = 0; i < 10; i++) {
        long start = System.nanoTime();
        String s = bi.toString();
        long mid = System.nanoTime();
        String s2 = toString(bi);
        long end = System.nanoTime();
        System.out.printf("time1 %.3f ms, time2 %.3f ms%n", (mid - start) / 1e6, (end - mid) / 1e6);
        if (!s.equals(s2))
            throw new AssertionError();
    }
}

public static String toString(BigInteger bi) {
    StringBuilder sb = new StringBuilder();
    int i = 16;
    while (bi.compareTo(powerOfTen(i)) > 0)
        i *= 2;
    toString(bi, sb, i);
    int start = 0;
    while (sb.charAt(start) == '0')
        start++;
    return sb.substring(start);
}

private static void toString(BigInteger bi, StringBuilder sb, int digits) {
    if (digits < 18) {
        int start = sb.length();
        for (int i = 0; i < digits; i++)
            sb.append('0');
        long l = bi.longValue();
        for (int i = digits - 1; i >= 0; i--, l /= 10)
            sb.setCharAt(start + i, (char) ('0' + l % 10));
    } else {
        int digits2 = digits / 2;
        BigInteger[] parts = bi.divideAndRemainder(powerOfTen(digits2));
        toString(parts[0], sb, digits - digits2);
        toString(parts[1], sb, digits2);
    }
}

private static final Map<Integer, BigInteger> powersOfTen = new HashMap<Integer, BigInteger>();

private static BigInteger powerOfTen(int digits2) {
    BigInteger tens = powersOfTen.get(digits2);
    if (tens == null)
        powersOfTen.put(digits2, tens = BigInteger.TEN.pow(digits2));
    return tens;
}