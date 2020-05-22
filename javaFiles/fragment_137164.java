public BigInteger sum(Long number1, Long number2) {
    BigInteger bigNumber1 = BigInteger.valueOf(number1);
    BigInteger bigNumber2 = BigInteger.valueOf(number2);
    BigInteger result = bigNumber1.add(bigNumber2);
    return result;
}