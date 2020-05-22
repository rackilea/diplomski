ListMultimap<Integer, String> mhm = Multimaps.newListMultimap(
  new TreeMap<Integer, Collection<String>>(),
  new Supplier<List<String>>() {
    public List<String> get() {
      return Lists.newArrayList();
    }
  });