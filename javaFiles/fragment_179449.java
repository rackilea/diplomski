public interface CacheMapFactory {
  public <K,V> Map<K,V> createCacheMap(String tag );
}

public class InMemoryCacheMapFactory implements CacheMapFactory {
  public <K,V> Map<K,V> createCacheMap(String tag ) {
    return new HashMap<K,V>();
  }
}

public class Test {
  public void test() {
    CacheMapFactory f = new InMemoryCacheMapFactory();
    Map<String, Long> m = f.createCacheMap( "mytag" ); //K and V are inferred from the assignment
  }
}