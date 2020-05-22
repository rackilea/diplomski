@Test
public void test() throws IOException {
  StatisticsService statisticsService = new DefaultStatisticsService();

  try(PersistentCacheManager persistentCacheManager = CacheManagerBuilder.newCacheManagerBuilder()
    .with(CacheManagerBuilder.persistence("myData"))
    .using(statisticsService)
    .withCache("threeTieredCache",
      CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
        ResourcePoolsBuilder.newResourcePoolsBuilder()
          .heap(10, EntryUnit.ENTRIES)
          .offheap(1, MemoryUnit.MB)
          .disk(20, MemoryUnit.MB, true)
      )
    ).build(true)) {

    Cache<Long, String> cache = persistentCacheManager.getCache("threeTieredCache", Long.class, String.class);
    for(long i = 0; i < 1000; i++) {
      cache.put(i, "test");
    }
    System.out.println("Length: " + getFolderSize("mydata"));
    TierStatistics tierStatistics = statisticsService
      .getCacheStatistics("threeTieredCache")
      .getTierStatistics()
      .get("Disk");
    System.out.println("Occupied: " + tierStatistics.getOccupiedByteSize());
    System.out.println("Allocated: " + tierStatistics.getAllocatedByteSize());
  }
}

private long getFolderSize(String folder) throws IOException {
  return Files.walk(Paths.get(folder))
    .filter(p -> p.toFile().isFile())
    .mapToLong(p -> p.toFile().length())
    .sum();
}