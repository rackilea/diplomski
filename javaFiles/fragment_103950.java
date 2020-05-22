public static void main(String... args) {
    for (String s : "A,a,aa,AA,a1,A1,ABCD,1234,'hi bye'".split(",")) {
        long l = hashFor(s);
        String s2 = decode(l);
        System.out.printf("Hashcode for %s is %d, decoded is %s%n", s, l, s2);
    }
}

public static long hashFor(String s) {
    long l = 0;
    for (int i = 0; i < s.length(); i++)
        l = l * 127 + s.charAt(i);
    return l & Long.MAX_VALUE; // stay positive
}

public static String decode(long l) {
    StringBuilder sb = new StringBuilder(9);
    while (l > 0) {
        sb.append((char) (l % 127));
        l /= 127;
    }
    return sb.reverse().toString();
}