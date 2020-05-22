public static long diff(final long a, final long b, final long c, final long d) {
    final long a0 = (a < b)?(b - a):(a - b);
    final long a1 = (c < d)?(d - c):(c - d);

    return a0 - a1;
}