Caffeine.newBuilder()
        .removalListener((key, value, cause) -> {
            if (cause.wasEvicted()) System.out.printf("key=%s, value=%s", key, value);
        })
        .expireAfterWrite(60, TimeUnit.SECONDS)
        .build();