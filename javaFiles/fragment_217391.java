public MyClass method(final String id1, final long id2)  {
    log.error("inside with "+id1);
    final String cacheKey = id1+"-"+id2;
    try {
        return cache.get(cacheKey);
    } catch (ExecutionException ex) {
        log.error("EEE missing entry",ex);
    }
}