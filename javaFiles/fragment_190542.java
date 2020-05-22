public static void main(String[] args) {
    int n = 5000;

    BigInteger Cn = BigInteger.ONE;
    for (int i = 0; i <= n; i++) {
        Cn = Cn.multiply(BigInteger.valueOf(4 * i + 2)).divide(BigInteger.valueOf(i + 2));
    }

    System.out.println(Cn);
}