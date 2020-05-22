ConcurrentMap<Identifier, SomeObject> cache = new MapMaker().makeComputingMap(new Function<Identifier, SomeObject>() {
  public SomeObject apply(Identifier from) {
    return createSomeObject(from);
  }
};

public SomeObject getObject(Identifier someIdentifier) {
  return cache.get(someIdentifier);
}