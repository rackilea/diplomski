private static final long K_PRIME = new BigInteger("9876534021204356789").longValue();

public static long hash(long a, int r) {
    // return (a * K_PRIME % (2^64)) >>> (64 - r);
    return (a * K_PRIME) >>> -r;
}