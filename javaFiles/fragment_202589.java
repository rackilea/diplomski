public class MemoizedRecursiveFibonacci implements Fibonacci {
  SimpleRecursiveFibonacci simple = new SimpleRecursiveFibonacci();
  private Map<Integer, BigInteger> cache = new HashMap<>();

  public BigInteger fibonacci(int n) {
    return cache.computeIfAbsent(n, k -> simple.fibonacci(k));
}