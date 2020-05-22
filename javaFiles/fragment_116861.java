public static void main(String... args) throws IOException {
  int length = 10 * 1000 * 1000;
  double[] x = new double[length];
  double[] y = new double[length];

  Random rand = new Random();
  for (int i = 0; i < length; i++) {
    x[i] = (rand.nextInt(10000) - rand.nextInt(10000)) / 1e4;
    y[i] = (rand.nextInt(10000) - rand.nextInt(10000)) / 1e4;
  }

  countPointsWithLongIntMap(x, y);
  countPointsWithMap(x, y);

}

private static Map<String, Short> countPointsWithMap(double[] x, double[] y) {
  long start = System.nanoTime();
  Map<String, Short> counts = new LinkedHashMap<String, Short>();
  for (int i = 0; i < x.length; i++) {
    String key = x[i] + "," + y[i];
    Short s = counts.get(key);
    if (s == null)
      counts.put(key, (short) 1);
    else
      counts.put(key, (short) (s + 1));
  }
  long time = System.nanoTime() - start;
  System.out.printf("Took %.3f seconds to use Map<String, Short>%n", time / 1e9);

  return counts;
}

private static TDoubleObjectHashMap<TDoubleIntHashMap> countPointsWithLongIntMap(double[] x, double[] y) {
  long start = System.nanoTime();
  TDoubleObjectHashMap<TDoubleIntHashMap> counts = new TDoubleObjectHashMap<TDoubleIntHashMap>();
  for (int i = 0; i < x.length; i++) {
    TDoubleIntHashMap map = counts.get(x[i]);
    if (map == null)
      counts.put(x[i], map = new TDoubleIntHashMap());
    map.adjustOrPutValue(y[i], 1, 1);
  }
  long time = System.nanoTime() - start;
  System.out.printf("Took %.3f seconds to use TDoubleObjectHashMap<TDoubleIntHashMap>%n", time / 1e9);
  return counts;
}