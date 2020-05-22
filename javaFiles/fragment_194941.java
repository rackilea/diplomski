public static BigInteger productOfOddIntegers(int n){
    BigInteger prod = BigInteger.ONE;
    BigInteger bin = new BigInteger(""+n);
    BigInteger two = BigInteger.ONE.add(BigInteger.ONE);
    for(BigInteger i = two.add(BigInteger.ONE); i.compareTo(bin) <= 0; i = i.add(two)) {
        prod = prod.multiply(i);
    }
    return prod;
}