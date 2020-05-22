int nlen = upperLimit.bitLength();
BigInteger nm1 = upperLimit.subtract(BigInteger.ONE);
BigInteger randomNumber, temp;
do {
    temp = new BigInteger(nlen + 100, randomSource);
    randomNumber = temp.mod(upperLimit);
} while (s.subtract(randomNumber).add(nm1).bitLength() >= nlen + 100);
// result is in 'randomNumber'