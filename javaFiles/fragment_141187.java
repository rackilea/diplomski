import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class TestCache {

    private static final String KEY = "Key";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CacheLoader<String, String> loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                System.out.println("Loading key");
                return key;
            }
        };
        LoadingCache<String, String> cache1 = CacheBuilder.newBuilder().expireAfterAccess(2L, TimeUnit.SECONDS)
                .expireAfterWrite(1L, TimeUnit.SECONDS).build(loader);
        cache1.get(KEY); // First write
        testCache(cache1);
        LoadingCache<String, String> cache2 = CacheBuilder.newBuilder().expireAfterAccess(2L, TimeUnit.SECONDS).build(loader);
        testCache(cache2);
        System.out.println("Final test on cache 2");
        Thread.sleep(2001);
        System.out.println(cache2.get(KEY));

    }

    private static void testCache(LoadingCache<String, String> cache1) throws ExecutionException, InterruptedException {
        Stopwatch sw = Stopwatch.createStarted();
        while (sw.elapsed(TimeUnit.SECONDS) < 5) {
            System.out.println(sw.elapsed(TimeUnit.MILLISECONDS) + " " + cache1.get(KEY));
            Thread.sleep(100);
        }
    }
}