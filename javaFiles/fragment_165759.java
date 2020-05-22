private static final Map<Pair<Integer, Integer>, Point> cache = new HashMap<>();

 public Point create(int x, int y) {
   Pair<Integer, Integer> key = Pair.of(x, y);
   if (cache.containsKey(key)) {
     return cache.get(key);
   }
   Point p = new Point(x, y);
   cache.put(key, p);
   return p;
 }