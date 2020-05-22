public class Test {

    public static void main(String[] args) {
        int hash = 100000;
        String sample = getStringForHashCode(hash);
        System.out.println(sample); // ASD^TYQ
        System.out.println(sample.hashCode()); // 100000
    }

    private static final int OFFSET = "AAAAAAA".hashCode();

    private static String getStringForHashCode(int hash) {
        hash -= OFFSET;
        // Treat it as an unsigned long, for simplicity.
        // This avoids having to worry about negative numbers anywhere.
        long longHash = (long) hash & 0xFFFFFFFFL;
        System.out.println(longHash);

        char[] c = new char[7];
        for (int i = 0; i < 7; i++)
        {
            c[6 - i] = (char) ('A' + (longHash % 31));
            longHash /= 31;
        }
        return new String(c);
    }
}