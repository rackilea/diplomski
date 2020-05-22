void sortedInsert2(List<T> list, T value, Comparator<T> comparator) {
  int pos = Collections.binarySearch(list, value, comparator);
  if (pos < 0) {
     pos = -pos -1; // returns negatives if not found; see javadoc
  }
  list.insert(value, pos);
}