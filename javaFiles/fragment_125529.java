// List is not efficient here; for large problems, something like SkipList 
// is more suitable
private static final List<String> KNOWN_INDEXES = asList("PREFZ", "PREFA");

private static final Function<Object, Integer> POSITION_IN_KNOWN_INDEXES 
    = new Function<Object, Integer>() {
  public Integer apply(Object in) {
     int index = KNOWN_INDEXES.indexOf(in);
     return index == -1 ? null : index;
  }     
};


...


List<String> values = asList("FOO", "BAR", "PREFA", "ZOO", "PREFZ", "PREFOO");

Collections.sort(values,
  Ordering.natural().nullsLast().onResultOf(POSITION_IN_KNOWN_INDEXES).compound(Ordering.natural())
);