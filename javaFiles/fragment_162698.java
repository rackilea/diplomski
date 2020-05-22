private void remove(int index, Node n) {
  if (n == null || index <= 0 || (index == 1 && n.next == null) {
    throw new IndexOutOfBoundsException();
  }
  if (index == 1) {
    // Remove 'n.next'.
    n.next = n.next.next; 
  } else {
    remove(index - 1, n.next);
  }
}