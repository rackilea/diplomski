public static BigInteger parityWordChecksum(final BigInteger key) {
    BigInteger result = new BigInteger("0");

    BigInteger mask = BigInteger.ZERO;
    for (int i = 0; i < 64; i++) {
        mask = mask.setBit(i);
    }

    for (int i = 0; i < 2048; i += 64) {
        result = result.xor(key.shiftRight(i).and(mask));
    }

    return result;
}