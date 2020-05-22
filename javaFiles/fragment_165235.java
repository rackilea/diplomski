// private means only this class can call the method.
private static long getFactorialSum(int n) {
  long fact = 1;
  long sum = 0;
  for (int i = 1; i <= n; i++) {
    fact *= i;
    sum += fact;
  }
  return sum;
}