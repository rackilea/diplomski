private static final BigInteger modulo = BigInteger.ONE.shiftLeft(32);

  public static int unoverflowDivide(int product, int divisor) {
    if (divisor == 0)
        throw new IllegalArgumentException("No solution");
    while((divisor & 1) == 0){
      if ((product & 1) == 1)
          throw new IllegalArgumentException("No solution"); 
      divisor >>= 1;
      product >>= 1;
    }
    BigInteger bigDivisor = BigInteger.valueOf(divisor);
    BigInteger bigProduct = BigInteger.valueOf(product);
    BigInteger bigInverse = bigDivisor.modInverse(modulo);
    BigInteger bigResult = bigInverse.multiply(bigProduct);
    return bigResult.intValue();
  }