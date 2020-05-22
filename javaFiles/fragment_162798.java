Random r = new Random();
BigInteger pow_10_25 = BigInteger.TEN.pow(25);
int minBitLength = pow_10_25.bitLength();

BigInteger p1 = BigInteger.probablePrime(minBitLength, r);
BigInteger p2 = BigInteger.probablePrime(minBitLength, r);  
BigInteger n = p1.multiply(p2);