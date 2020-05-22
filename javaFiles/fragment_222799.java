public static BigInteger randomForBitsNonZero(int numBits, Random r) {
    BigInteger candidate = new BigInteger(numBits, r);
    while(candidate.equals(BigInteger.ZERO)) {
        candidate = new BigInteger(numBits, r); 
    }
    return candidate;
}