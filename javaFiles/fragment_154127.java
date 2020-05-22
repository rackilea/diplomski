import java.util.concurrent.atomic.AtomicInteger

import net.sf.ehcache.Cache
import net.sf.ehcache.CacheManager
import net.sf.ehcache.store.MemoryStoreEvictionPolicy

import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean

class MyService implements InitializingBean, DisposableBean {

   private static AtomicInteger counter = new AtomicInteger()

   private Cache cache
   private String cacheName

   static scope = 'session'

   void afterPropertiesSet() {

      int maxElementsInMemory = 10000
      int maxElementsOnDisk = 10000000
      MemoryStoreEvictionPolicy memoryStoreEvictionPolicy = MemoryStoreEvictionPolicy.LRU
      boolean overflowToDisk = true
      boolean eternal = false
      int timeToLive = 5000 // 120
      int timeToIdle = 5000 // 120
      boolean diskPersistent = false
      int diskExpiryThreadIntervalSeconds = 120
      int diskSpoolBufferSize = 0

      cacheName = 'myservice-cache-' + counter.incrementAndGet()

      cache = new Cache(cacheName, maxElementsInMemory, memoryStoreEvictionPolicy,
                  overflowToDisk, null, eternal, timeToLive, timeToIdle,
                  diskPersistent, diskExpiryThreadIntervalSeconds, null,
                  null, maxElementsOnDisk, diskSpoolBufferSize)

      CacheManager.getInstance().addCache cache
   }

   void destroy() {
      cache.removeAll()
      CacheManager.getInstance().removeCache(cacheName)
   }
}