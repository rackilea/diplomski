Random rand = new Random();
  for (int i = 0; i < length; i++) {
    x[i] = rand.nextInt(10000) - rand.nextInt(10000);
    y[i] = rand.nextInt(10000) - rand.nextInt(10000);
  }

  countPointsWithLongIntMap(x, y);
  countPointsWithMap(x, y);

}

private static Map<String, Short> countPointsWithMap(int[] x, int[] y) {
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
  System.out.printf("Took %.3f seconds to use Map<String, Short>%n", time/1e9);

  return counts;
}

private static TIntIntHashMap countPointsWithLongIntMap(int[] x, int[] y) {
  long start = System.nanoTime();
  TIntIntHashMap counts = new TIntIntHashMap();
  for (int i = 0; i < x.length; i++) {
    int key =  (x[i] << 16) | (y[i] & 0xFFFF);
    counts.adjustOrPutValue(key, 1, 1);
  }
  long time = System.nanoTime() - start;
  System.out.printf("Took %.3f seconds to use TIntIntHashMap%n", time/1e9);
  return counts;
}