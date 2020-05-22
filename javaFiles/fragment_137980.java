LoadingCache<String, List<YourObjectType>> myCache = CacheBuilder.newBuilder()
    .expireAfterWrite(60, TimeUnit.MINUTES)
    .build(new CacheLoader<String, List<YourObjecttype>>() {
        public List<YourObjectType> load(String arg) {
            ...
        }
});