public boolean hasNext() {
  return current != null;
}
public E next() {
    if (!hasNext()) throw new NoSuchElementException();
    E tmp = current.item;
    current = current.next;  // if next is null, hasNext will return false.
    return tmp;
}