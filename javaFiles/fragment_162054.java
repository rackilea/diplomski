public <K, V> Cache<K, V> getOrCreateCache(String identifier, Class<K> keyClass, Class<V> valueClass) {
  Identifier cacheIdentifier = new Identifier(identifier, keyClass, valueClass);
  // safe cast as we know that this cacheIdentifier must has a Cache<K, V>
  Cache<K, V> cache = (Cache<K, V>) caches.get(identifier);
  if (cache == null) {
    cache = new CacheImpl<K, V>();
    caches.put(cacheIdentifier, cache);
  }
  return cache;
}

/*
 * not the most efficient implementation, but correctly implements hashCode and equals
 * which is all we need
 */
private static class CacheIdentifier extends ArrayList<Object> {
  private CacheIdentifier(String identifier, Class<K> keyClass, Class<V> valueClass) {
    super(3);
    // TODO check for null
    add(identifier);
    add(keyClass);
    add(valueClass);
  }
}