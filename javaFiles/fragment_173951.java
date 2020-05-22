static Map<BigInteger, BigInteger> memo = new HashMap<>();
static {
    int[] initial = { 0, 1, 1, 2, 4, 8 };
    for (int i = 0; i < initial.length; i++) {
        memo.put(BigInteger.valueOf(i), BigInteger.valueOf(initial[i]));
    }
}

public static BigInteger calc(BigInteger n) {
    if (memo.containsKey(n)) {
        return memo.get(n);
    }
    BigInteger orig = n, v = BigInteger.ZERO;
    for (int i = 0; i < 6; i++) {
        n = n.subtract(BigInteger.ONE);
        v = v.add(calc(n));
    }
    memo.put(orig, v);
    return v;
}