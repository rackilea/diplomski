class IFactory {
  @Inject Injector injector; // This is a bad idea, except for times like this
  @Inject Provider<B> defaultI;
  static final ImmutableMap<Integer, Class<? extends I>> map = ImmutableMap.of(
      1, A.class,
      3, C.class,
      4, D.class);

  I getI(int i) {
    return map.containsKey(i)
        ? injector.getInstance(map.get(i))
        : defaultI.get();
  }
}