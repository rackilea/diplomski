import com.google.common.cache.*;

class SomeClass {
    private final LoadingCache<String, Resource> resourceMap =
            CacheBuilder.newBuilder()
                    .maximumSize(10L)
                    .build(new CacheLoader<String, Resource>() {
                        @Override
                        public Resource load(String key) {
                            return new Resource();
                        }
                    });

    public Resource getResource(String resourceId) {
        return resourceMap.getUnchecked(resourceId);
    }

    private static class Resource {
    }
}