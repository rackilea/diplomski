public static void skipSecure(InputStream is, long n) throws IOException {
    while (n >= 0) {
        long skipped = is.skip(n);
        n -= skipped;
    }
}