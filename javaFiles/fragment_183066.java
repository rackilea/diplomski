class IFactory {
  @Inject Map<Integer, Provider<I>> iMap;
  @Inject Provider<B> defaultI; // Bound automatically for every Guice key

  I getI(int i) {
    return iMap.containsKey(i) ? iMap.get(i).get() : defaultI.get();
  }
}