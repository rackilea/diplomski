final long RECHECK_INTERVAL_MILLIS = 30000;
Cache<UUID, CompletableFuture<Void>> cache =
  new Cache2kBuilder<UUID, CompletableFuture<Void>>(){}
    .loader(new AdvancedCacheLoader<UUID, CompletableFuture<Void>>() {
      @Override
      public CompletableFuture<Void> load(UUID key,
                                          long currentTime,
                                          CacheEntry<UUID, CompletableFuture<Void>> currentEntry) {
        return currentEntry != null ? currentEntry.getValue() : null;
      }
    })
    .expiryPolicy(new ExpiryPolicy<UUID, CompletableFuture<Void>>() {
      @Override
      public long calculateExpiryTime(UUID key,
                                      CompletableFuture<Void> value,
                                      long loadTime,
                                      CacheEntry<UUID, CompletableFuture<Void>> oldEntry) {
        return value.isDone() ? NOW : loadTime + RECHECK_INTERVAL_MILLIS;
      }
    })
    .refreshAhead(true)
    .build();