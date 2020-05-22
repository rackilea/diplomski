public static final BigInteger BI_K_PRIME = new BigInteger("9876534021204356789");
private static long K_PRIME = BI_K_PRIME.longValue();

public static long hash(long a, int r) {
    // return (a * K_PRIME % (2^64)) >>> (64 - r);
    return (a * K_PRIME) >>> -r;
}

public static long biHash(long a, int r) {
    return BigInteger.valueOf(a).multiply(BI_K_PRIME).mod(BigInteger.valueOf(2).pow(64)).shiftRight(64 - r).longValue();
}

public static void main(String... args) {
    Random rand = new Random();
    for (int i = 0; i < 10000; i++) {
        long a = rand.nextLong();
        for (int r = 1; r < 64; r++) {
            long h1 = hash(a, r);
            long h2 = biHash(a, r);
            if (h1 != h2)
                throw new AssertionError("Expected " + h2 + " but got " + h1);
        }
    }

    int runs = 1000000;
    long start1 = System.nanoTime();
    for (int i = 0; i < runs; i++)
        hash(i, i & 63);
    long time1 = System.nanoTime() - start1;

    long start2 = System.nanoTime();
    for (int i = 0; i < runs; i++)
        biHash(i, i & 63);
    long time2 = System.nanoTime() - start2;
    System.out.printf("hash with long took an average of %,d ns, " +
            "hash with BigInteger took an average of %,d ns%n",
            time1 / runs, time2 / runs);
}