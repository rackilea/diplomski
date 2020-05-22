import java.util.Map;
import org.springframework.cache.Cache;
import com.couchbase.client.spring.cache.CacheBuilder;
import com.couchbase.client.spring.cache.CouchbaseCacheManager;

public class CouchbaseCustomCacheManager extends CouchbaseCacheManager {

    public CouchbaseCustomCacheManager(
            final Map<String, CacheBuilder> initialCaches) {
        super(initialCaches);
    }

    @Override
    public Cache getCache(String name) {
        return new CouchbaseCacheWrapper(super.getCache(name));
    }

    protected static class CouchbaseCacheWrapper implements Cache {

        private final Cache delegate;

        public CouchbaseCacheWrapper(Cache couchbaseCache) {
            this.delegate = couchbaseCache;
        }

        @Override
        public String getName() {
            try {
                return delegate.getName();
            } catch (Exception e) {
                return null;
            }
        }

        @Override
        public Object getNativeCache() {
            try {
                return delegate.getNativeCache();
            } catch (Exception e) {
                return null;
            }
        }

        @Override
        public ValueWrapper get(Object key) {
            try {
                return delegate.get(key);
            } catch (Exception e) {
                return null;
            }
        }

        @Override
        public <T> T get(Object key, Class<T> type) {
            try {
                return delegate.get(key, type);
            } catch (Exception e) {
                return null;
            }
        }

        @Override
        public void put(Object key, Object value) {
            try {
                delegate.put(key, value);
            } catch (Exception e) {
                try {
                    handleErrors(e);
                } catch (Exception e1) {
                }
            }
        }

        @Override
        public ValueWrapper putIfAbsent(Object key, Object value) {
            try {
                return delegate.putIfAbsent(key, value);
            } catch (Exception e) {
                return null;
            }
        }

        @Override
        public void evict(Object key) {
            try {
                delegate.evict(key);
            } catch (Exception e) {
                try {
                    handleErrors(e);
                } catch (Exception e1) {
                }
            }
        }

        @Override
        public void clear() {
            try {
                delegate.clear();
            } catch (Exception e) {
                try {
                    handleErrors(e);
                } catch (Exception e1) {
                }
            }
        }

        protected <T> T handleErrors(Exception e) throws Exception {
            if (e instanceof Exception) {
                return null;
            } else {
                throw e;
            }
        }
    }

}