Cache<String, String> cache = CacheBuilder.newBuilder()
    .expireAfterWrite(60, TimeUnit.SECONDS)
    .removalListener(new RemovalListener<String, String>() {
      public void onRemoval(RemovalNotification<String, String> removal) {
        // Compute the average here
      }          
    })
    .build();