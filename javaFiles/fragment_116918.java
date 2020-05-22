final static BigInteger targetDiff = new BigInteger("2").pow(512);

public boolean checkDiff(BigInteger p, BigInteger q){
    BigInteger pDiff = p.subtract(q);
    pDiff = pDiff.abs();

    BigInteger diff = pDiff.subtract(targetDiff);

    return diff.compareTo(BigInteger.ZERO) == 1;
}