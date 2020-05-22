public final class Values {
    public static final int ANY_INT = randomInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
    public static final int ANY_POSITIVE_INT = randomInt(0, Integer.MAX_VALUE);
    public static final String ANY_ISBN = randomIsbn();
    // etc...

    public static int randomInt(int min, int max) { /* omitted */ }
    public static String randomIsbn() { /* omitted */ }

    // etc...
}