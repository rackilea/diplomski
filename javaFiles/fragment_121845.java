storage = CacheBuilder.newBuilder()
            .expireAfterAccess(5, TimeUnit.SECONDS)
            .maximumSize(MAX_SIZE)
            .removalListener(notification -> LOG.info("Element was remove: " + notification.getKey()))
            .build(new CacheLoader<String, CacheValue>() {
                @Override
                public CacheValue load(String key) {
                    return (CacheValue) value;
                }
            });