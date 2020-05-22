Arrays.sort(theHeap, new Comparator() {
  public int compare(Object o1, Object o2) {
    // nulls are "greater" than non-nulls
    if (o1 == null && o2 != null) return 1;
    // non-nulls are "smaller" than nulls
    if (o1 != null && o2 == null) return -1;
    // in all other comparisons, we don't care
    return 0;
  }
});