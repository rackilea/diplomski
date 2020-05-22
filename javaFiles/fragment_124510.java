HashMap merged = new HashMap<String, Integer>();

for (String x : map1.getKeySet()) {
   Integer y = map2.get(x);
   if (y == null) {
      merged.put(x, map1.get(x));
   } else {
      merged.put(x, map1.get(x)+y);
   }
}

for (String x : map2.getKeySet()) {
   if (merged.get(x) == null) {
      merged.put(x, map2.get(x));
   }
}