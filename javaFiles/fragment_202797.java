Multimaps.newSetMultimap(
  TDecorators.wrap(new TIntObjectHashMap<Collection<Integer>>()),
  new Supplier<Set<Integer>>() {
    public Set<Integer> get() {
      return TDecorators.wrap(new TIntHashSet());
    }
  });