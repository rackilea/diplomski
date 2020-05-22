class SomeClass {
  private final ConcurrentMap<String, Resource> resourceMap = new ConcurrentHashMap<>();

  public Resource getResource(String resourceId) {
      return resourceMap.computeIfAbsent(resourceId, r -> new Resource());
  }

  private static class Resource {}
}