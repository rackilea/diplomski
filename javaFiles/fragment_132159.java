int n = 0;
BigInteger factorial = BigInteger.ONE;
while (n <= 30) {
    System.out.printf("Factorial(%d) = %s%n", n, factorial);
    n++;
    factorial = factorial.multiply(BigInteger.valueOf(n));
}