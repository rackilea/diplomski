public static double expSeries(double x, int n) {
  double term = 1;
  double result = term;
  for (int i = 1; i <= n; i++) {
    term *= x / i;
    result += term;
  }
  return result;
}