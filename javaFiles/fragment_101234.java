static boolean isProbablyPrime(int n) {
    BigInteger bigN = BigInteger.valueOf(n);
    BigInteger two = BigInteger.valueOf(2);
    BigInteger t = two.modPow(bigN, bigN);
    return t.longValue() == 2;
}