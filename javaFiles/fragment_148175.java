class MyProxyGenerator {
  static Map<Class<?>, Class<?>> proxies = new HashMap<>();
  public Class<?> makeProxy(Class<?> type) {
    if(proxies.contains(type)) {
      return proxies.get(type);
    } else {
      Class<?> proxy = doMakeProxy(type);
      proxies.put(type, proxy);
      return proxy;
    }
  }
  private Class<?> doMakeProxy(Class<?> type) {
    // use Byte Buddy here.
  }
}