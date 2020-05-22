MyStrategy createMyStrategy() {
  MyStrategy strategy;
  try {
    Class.forName("net.sf.ehcache.CacheManager");
    strategy = new MyLibraryUsingStrategy();
  } catch (ClassNotFoundException e) {
    strategy = new MyEmbeddedStrategy();
  }
  return strategy;
}