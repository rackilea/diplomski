underTest = CacheBuilder.from("maximumSize=0")
                .recordStats()
                .removalListener(new RemovalListener<String, Long>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, Long> removalNotification) {
                        LOG.info(String.format("%s cached value %s for key %s is evicted.", removalNotification.getCause().name(), removalNotification.getValue(), removalNotification.getKey()));
                    }
                })
                .build(new CacheLoader<String, Long>() {
                    private final AtomicLong al = new AtomicLong(0);
                    @Override
                    public Long load(@NotNull final String key) throws Exception {
                        LOG.info(String.format("Cache miss for key '%s'.", key));
                        return al.incrementAndGet();
                    }
                });