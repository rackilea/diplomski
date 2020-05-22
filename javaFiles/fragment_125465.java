private static void printDigits(BigInteger num) {
    BigInteger[] resultAndRemainder;
    do {
        resultAndRemainder = num.divideAndRemainder(BigInteger.TEN);
        System.out.println(Math.abs(resultAndRemainder[1].intValue()));
        num = resultAndRemainder[0];
    } while (num.compareTo(BigInteger.ZERO) != 0);
}