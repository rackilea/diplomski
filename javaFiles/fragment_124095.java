private static Map<Long, BigInteger> memo = new HashMap<>();
static {
    memo.put(0L, BigInteger.ZERO);
    memo.put(1L, BigInteger.ONE);
    memo.put(2L, BigInteger.ONE);
}

public static BigInteger operation(long n) {
    if (memo.containsKey(n)) {
        return memo.get(n);
    }
    final long m = Math.abs(n);
    BigInteger ret = n < 0 //
            ? BigInteger.valueOf(m % 2 == 0 ? -1 : 1).multiply(operation(m))
            : operation((n - 2)).add(operation((n - 1)));
    memo.put(n, ret);
    return ret;
}