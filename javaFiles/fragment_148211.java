static long calc(int n, int k, int m) {
    BigInteger left = new BigInteger("2");
    BigInteger nBig = new BigInteger(String.valueOf(n - 3));
    BigInteger mod = new BigInteger(String.valueOf(m));
    left = left.modPow(nBig, mod);

    BigInteger right = new BigInteger("2");
    right = right.pow(k + 2);
    right = right.subtract(new BigInteger(String.valueOf(n)));
    right = right.mod(mod);

    left = left.multiply(right);
    left = left.mod(mod);

    return left.longValue();
}