public class SimpleRecursiveFibonacci {

    /** Gets the fibonacci value for n */
    public final BigInteger fibonacci(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        } else if (n == 1) {
            return BigInteger.ONE;
        }
        return getFibonacci(n);
    }

    /** Recursively calculates the fibonacci by adding the two previous fibonacci. */
    protected final BigInteger calculateFibbonacci(int n) {
        return fibonacci(n - 2).add(fibonacci(n - 1));
    }

    /** 
     * Somehow get the fibonacci value for n.
     * Could be by calculation, getting it from a cache, or anything.
     * Defaults to calculation.
     */
    protected BigInteger getFibonacci(int n) {
        return calculateFibbonacci(n);
    }

}

public class MemoizedRecursiveFibonacci extends SimpleRecursiveFibonacci {

    // Cache using an array list as recommended by user @DodgyCodeException
    private ArrayList<BigInteger> cache = new ArrayList<>();

    @Override
    protected BigInteger getFibonacci(int n) {
        if (cache.size() < n) {
            BigInteger fib = calculateFibbonacci(n);
            cache.add(fib);
            return fib;
        } else {
            return cache.get(n - 1);
        }
    }
}