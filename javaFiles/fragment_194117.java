public class CachedObservable<K,V> {
  private Function<K, Observable<V>> actual;
  private CachedObservable(Function<K, Observable<V>> actual){this.actual=actual;}
  private final Map<K, Observable<V>> cacheMap = new ConcurrentHashMap<>();

  public Observable<V> get(K key) {
    return cacheMap.computeIfAbsent(key, k -> this.actual.call(k).cache());
  }
  public void invalidate(K key){cacheMap.remove(key);}
}