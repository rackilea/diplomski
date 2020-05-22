public class CustomGuavaCacheManager extends org.springframework.cache.guava.GuavaCacheManager {

  @Override
  protected Cache createGuavaCache(String name) {
    return new CustomGuavaCache(name, createNativeGuavaCache(name), isAllowNullValues());
  }
}