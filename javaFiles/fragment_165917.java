private static final byte[] bitPositions(long n) {
    final byte[] result = new byte[Long.bitCount(n)];

    int i = 0;
    for (byte bit = 1; n != 0L; bit++) {
        if ((n & 1L) != 0) result[i++] = bit;
        n >>>= 1;
    }

    return result;
}