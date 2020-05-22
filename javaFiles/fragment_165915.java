private static final byte[] bitPositions(long n) {
    final byte[] result = new byte[Long.bitCount(n)];

    for (int i = 0; n != 0L; i++) {
        result[i] = (byte) ((byte) Long.numberOfTrailingZeros(n) + 1);
        n &= n - 1L;  // Change least-significant one bit to a zero bit.
    }

    return result;
}