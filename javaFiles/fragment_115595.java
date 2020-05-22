CacheLoader<Key, Graph> loader = new CacheLoader<Key, Graph>() {
  public Graph load(Key key) throws AnyException {
    return createExpensiveGraph(key);
  }
};
LoadingCache<Key, Graph> cache = CacheBuilder.newBuilder().build(loader);