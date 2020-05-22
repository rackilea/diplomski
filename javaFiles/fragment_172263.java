public void test() {
  double [] tests = new double[] {1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9};
  for ( double d : tests) {
    System.out.println("    "+d + " -> "+round(d, .05, 0.5));
  }
}

double round(double d, double fraction, double bias) {
  return Math.floor(d / fraction + bias) * fraction;
}