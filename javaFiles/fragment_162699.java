public void remove(int index) {
  if (first == null || index < 0) {
    throw new IndexOutOfBoundsException();
  }
  if (index == 0) {
    // Remove 'first'.
    first = first.next;
  } else {
    remove(index, first);
  }
  size--;
}