public CacheManager(Class<Dao> clazz, Class<Pojo> _clazz_pojo) {
    Class<List<Pojo>> valueClass = cast(List.class);
    _cache = cacheManager.getCache(_clazz_pojo.getName(), String.class, valueClass);

    if(_cache == null){
        _cache = cacheManager.createCache(_clazz_pojo.getName(),
                CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, valueClass,
                        ResourcePoolsBuilder.heap(10)));
    }

    // ...
}

@SuppressWarnings("unchecked")
private <T, V> Class<V> cast(Class<T> t) {
    return (Class<V>) t;
}