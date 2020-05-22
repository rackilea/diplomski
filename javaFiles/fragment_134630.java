Map<Integer, Collection<Integer>> map = Maps.newTreeMap();
ListMultimap<Integer, Integer> m = Multimaps.newListMultimap(map,
    new Supplier<List<Integer>>() {
      public List<Integer> get() {
        return Lists.newArrayList(); // assuming you want to use ArrayList
      }
    });