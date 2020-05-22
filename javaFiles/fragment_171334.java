abstract class Repository<T> {
    // .. some methods omitted for brevity

    @Cacheable(cacheResolver = CachingConfiguration.CACHE_RESOLVER_NAME)
    public List<T> findAll() {
        return getDao().findAll();
    }
}