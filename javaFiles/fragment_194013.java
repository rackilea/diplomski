public static double expSeries(double x, int n) {
  BigDecimal result = ONE;
  BigDecimal term = ONE;
  BigDecimal x_ = new BigDecimal(x);
  for (int i = 1; i <= n; i++) {
    term = term.multiply(x_.divide(BigDecimal.valueOf(i), MathContext.DECIMAL128));
    result = result.add(term);
  }
  return result.doubleValue();
}