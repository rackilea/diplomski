void sortedInsert(List<T> list, T value, Comparator<T> comparator) {
  int pos=0;
  ListIterator<T> it=list.listIterator();
  while (it.hasNext() && comparator.compare(value, it.next()) < 0) pos ++;
  if (pos < it.previousIndex()) it.previous();
  it.add(value);
}