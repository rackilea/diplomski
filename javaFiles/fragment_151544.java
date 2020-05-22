public interface CacheKey<K extends Serializable> extends Serializable {
    K get();
}

public interface CacheValue<V extends Serializable> extends Serializable {
    V get();
}

public interface Cache<K extends CacheKey<? extends Serializable>, V extends CacheValue<? extends Serializable>> {
    void put(K key, V value);
}

public class CacheImpl implements Cache<CacheKey<String>, CacheValue<String>> {
    @Override
    public void put(CacheKey<String> key, CacheValue<String> value) {
        // do whatever
    }
}