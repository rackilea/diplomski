public static BigInteger rndBigInt(BigInteger max) {
    Random rnd = new Random();
    do {
        BigInteger i = new BigInteger(max.bitLength(), rnd);
        if (i.compareTo(max) <= 0)
            return i;
    } while (true);
}

public static void main(String... args) {
    System.out.println(rndBigInt(new BigInteger("8180385048")));
}