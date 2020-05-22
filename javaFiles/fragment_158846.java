private static class EntityCleanup {
    private final EntityRegionAccessStrategy cacheAccess;
    private final SoftLock cacheLock;

    private EntityCleanup(EntityRegionAccessStrategy cacheAccess) {
        this.cacheAccess = cacheAccess;
        this.cacheLock = cacheAccess.lockRegion();
        cacheAccess.removeAll();
    }

    private void release() {
        cacheAccess.unlockRegion( cacheLock );
    }
}

private static class CollectionCleanup {
    private final CollectionRegionAccessStrategy cacheAccess;
    private final SoftLock cacheLock;

    private CollectionCleanup(CollectionRegionAccessStrategy cacheAccess) {
        this.cacheAccess = cacheAccess;
        this.cacheLock = cacheAccess.lockRegion();
        cacheAccess.removeAll();
    }

    private void release() {
        cacheAccess.unlockRegion( cacheLock );
    }
}

private class NaturalIdCleanup {
    private final NaturalIdRegionAccessStrategy naturalIdCacheAccessStrategy;
    private final SoftLock cacheLock;

    public NaturalIdCleanup(NaturalIdRegionAccessStrategy naturalIdCacheAccessStrategy) {
        this.naturalIdCacheAccessStrategy = naturalIdCacheAccessStrategy;
        this.cacheLock = naturalIdCacheAccessStrategy.lockRegion();
        naturalIdCacheAccessStrategy.removeAll();
    }

    private void release() {
        naturalIdCacheAccessStrategy.unlockRegion( cacheLock );
    }
}