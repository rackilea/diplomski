public static String factorial(int n) {
    if(n < 1) return "0";
    BigInteger fact = new BigInteger("1");
    for (int i = 1; i <= n; i++) {
        fact = fact.multiply(new BigInteger(i + ""));
    }
    return fact.toString();
}