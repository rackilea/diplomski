static final ConcurrentMap<Integer, Resource> map = new ConcurrentHashMap<>();

static Resource loadResource(int resourceId) {
    return map.computeIfAbsent(resourceId, r -> {
        Resource resource = new Resource(r);
        resource.load();
        return resource;
    }
}