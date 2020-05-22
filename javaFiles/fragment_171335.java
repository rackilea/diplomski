class RuntimeCacheResolver
        extends SimpleCacheResolver {

    protected RuntimeCacheResolver(CacheManager cacheManager) {
        super(cacheManager);
    }

    @Override
    protected Collection<String> getCacheNames(CacheOperationInvocationContext<?> context) {
        return Arrays.asList(context.getTarget().getClass().getSimpleName());
    }
}