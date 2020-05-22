public static void main(String... args) {
    String s = "1111111111111111111111111111111111111111111111111111111110000101";
    long l = parseLong(s, 2);
    System.out.println(s +" => " + l);

    String s2 = s.substring(1);
    long l2 = parseLong(s2, 2);
    System.out.println(s2 +" => " + l2);
}

private static long parseLong(String s, int base) {
    return new BigInteger(s, base).longValue();
}