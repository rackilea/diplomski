public static BigInteger sumDigits(BigInteger n) {
    BigInteger num = n;
    BigInteger sum = BigInteger.ZERO;
    BigInteger ten = BigInteger.valueOf(10);
    while (num.compareTo(BigInteger.ZERO) > 0) {
        sum = sum.add(num.mod(ten));
        num = num.divide(ten);
    }
    return sum;
}

public static void main(String[] args) {
    System.out.println(sumDigits(BigInteger.valueOf(2).pow(1000)));
}