public class CustomGuavaCache extends org.springframework.cache.guava.GuavaCache {

  protected boolean isMatch(String key, String pattern) {
    ...
  }

  protected boolean isPattern(String key) {
    ...
  }

  @Override
  public void evict(Object key) {
    if (key instanceof String && isPattern(key.toString()))) {
        Map<String, Object> entries = this.cache.asMap();
        Set<String> matchingKeys = new HashSet<>(entries.size());
        for (String actualKey : entries.keySet()) {
          if (isMatch(actualKey, key.toString()) {
            matchingKeys.add(actualKey);
          }
        }
        this.cache.invalidateAll(matchingKeys);
    }
    else {
      this.cache.invalidate(key);
    }
  }
}