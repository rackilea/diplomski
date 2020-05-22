private static Map<Integer, BigInteger> memo = new HashMap<>();

public static BigInteger fibonacci3(int n) {
    if (n == 0 || n == 1) {
        return BigInteger.ONE;
    }
    if (memo.containsKey(n)) {
        return memo.get(n);
    }
    BigInteger v = fibonacci3(n - 2).add(fibonacci3(n - 1));
    memo.put(n, v);
    return v;
}