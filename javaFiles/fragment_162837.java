temp = d2;

while (temp.compareTo(BigInteger.ZERO) > 0) {           
    BigInteger[] divideAndRemainder = temp.divideAndRemainder(BigInteger.valueOf(10));
    temp = divideAndRemainder[0];
    sum = sum.add(divideAndRemainder[1]);
}