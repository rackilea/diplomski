public interface CacheMapFactory {
  public <K,V> Map<K,V> createCacheMap(String tag, Class<K> kClass, Class<V> vClass);
}

public class InMemoryCacheMapFactory implements CacheMapFactory {
  public <K,V> Map<K,V> createCacheMap(String tag, Class<K> kClass, Class<V> vClass) {
    return new HashMap<K,V>();
  }
}