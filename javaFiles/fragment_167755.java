import java.util.concurrent.TimeUnit;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhCacheFixedExpirationTest {
public static void main(String[] args) {
    CacheManager cacheManager = new CacheManager();
    Cache testCache = new Cache("testCache", 100, false, false, 10, 10);
    cacheManager.addCache(testCache);

    Element element = new Element("1", "20");
    element.setTimeToLive(1);
    testCache.put(element);

    long start = System.nanoTime();

    while (testCache.get("1") != null) {
        //wait
    }
    System.out.println(TimeUnit.MILLISECONDS.convert((System.nanoTime() - start), TimeUnit.NANOSECONDS));
}
}