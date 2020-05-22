private static BigInteger fib(int n, HashMap<Integer, BigInteger> memoized) {
    System.out.println(" n = " + n);
    if (memoized.containsKey(n)) {
        return memoized.get(n);
    } else if (n <= 0) {
        return BigInteger.ZERO;
    } else if (n <= 2) {
        return BigInteger.ONE;
    } else {
        BigInteger sum = fib(n - 1, memoized).add(fib(n - 2, memoized));
        System.out.println(" fib(" + n + ") = " + sum;
        memoized.put(n, sum);
        return sum;
    }
}