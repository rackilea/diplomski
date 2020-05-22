final List<String> namesToKeep = getNamesToFilter();
List<MyObject> filtered = Collections2.filter(originalList, new Predicate<MyObject>() {
  @Override
  public boolean apply(MyObject o) {
    return namesToKeep.contains(o.getName());
  }
});