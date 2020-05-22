private static Map<Number, Number> factorials = new HashMap<> ();

private static <T extends Number> T factorial(T n, BinaryOperator<T> multiply, UnaryOperator<T> decrement) {
  if (n.doubleValue() == 1) return n;
  T result = (T) factorials.get(n);
  if (result == null ){
    result = multiply.apply(n, factorial(decrement.apply(n), multiply, decrement));
    factorials.put(n, result);
  }
  return result;
}