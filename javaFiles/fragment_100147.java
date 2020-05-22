private static <K, V> Multimap<V, K> reverseMap(Map<K, V> source) {
   Multimap<V, K> multimap = ArrayListMultimap.create();
   for (Map.Entry<K, V> entry : source.entrySet()) {
      multimap.put(entry.getValue(), entry.getKey());
   }
   return multimap;
}