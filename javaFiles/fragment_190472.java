Map<String, List<? extends Foobar> maps = ...;
Maps.transformValues(maps, new Function<List<? extends Foobar>, ImmutableList<? extends Foobar>>() {
  public ImmutableList<? extends Foobar> apply(List<? extends Foobar> list) {
    return ImmutableList.copyOf(list);
  }
});
ImmutableMap.copyOf(maps);