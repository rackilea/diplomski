import org.ehcache.Cache;
import org.ehcache.PersistentCacheManager;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.ehcache.config.builders.CacheConfigurationBuilder.*;
import static org.ehcache.config.builders.CacheManagerBuilder.*;
import static org.ehcache.config.builders.ResourcePoolsBuilder.*;

public class Main {

  private static final Logger log = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    try(PersistentCacheManager persistentCacheManager =
        newCacheManagerBuilder()
            .with(persistence("cache"))
            .withCache("test-cache",
                newCacheConfigurationBuilder(
                    Integer.class, String.class,
                    newResourcePoolsBuilder()
                        .heap(1, EntryUnit.ENTRIES)
                        .offheap(1, MemoryUnit.MB)
                        .disk(20, MemoryUnit.MB, true)
                )
            ).build(true)) {
      Cache cache = persistentCacheManager.getCache("test-cache", Integer.class, String.class);

      log.info("Cache get 1 before putting: " + cache.get(1));
      for (int i = 0; i < 1000; i++) {
        cache.put(i, "Hello");
      }
      log.info("Cache get 1 after putting: " + cache.get(1));
    }
  }
}