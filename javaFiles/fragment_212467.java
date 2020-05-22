static double minRecur(double... ds) {
  return minRecur(ds, 0, Double.POSITIVE_INFINITY);
}
static double minRecur(double[] ds, int i, double runningMin) {
  return (i < 0 || i >= ds.length)? 
    runningMin : minRecur(ds, i + 1, Math.min(runningMin, ds[i]));
}