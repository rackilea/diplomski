Cache cache = // a JSR107 cache
MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
ObjectName name = new ObjectName("javax.cache:type=CacheStatistics," +
  "CacheManager=" + cache.getCacheManager().getURI().toString() +
  ",Cache=" + mbeanSafe(cache.getName()));
long hits = mBeanServer.getAttribute(name, "CacheHits");