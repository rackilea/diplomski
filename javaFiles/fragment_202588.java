public class MemoizedRecursiveFibonacci implements Fibonacci {
  SimpleRecursiveFibonacci simple = new SimpleRecursiveFibonacci();
  private Map<Integer, BigInteger> cache = new HashMap<>();

  public BigInteger fibonacci(int n) {
    if(!cache.containsKey(n)) {
      BigInteger currentFibonacci = simple.fibonacci(n);
      cache.put(n, currentFibonacci);
    }

    return cache.get(n);
  }
}