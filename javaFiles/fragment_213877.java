List<Item> items = ... ;
java.util.Collections.sort(items, new ItemNameComparator());

 private static class ItemNameComparator implements Comparator<Item> {
  @Override
  public int compare(Item a, Item b) {
    return a.getName().compareTo(b.getName());
  }
}