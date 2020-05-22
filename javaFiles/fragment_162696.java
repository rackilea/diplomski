private void remove(int index, int current, Node n) {
  if (n == null || index <= 0 || (index == 1 && n.next == null) {
    throw new IndexOutOfBoundsException();
  }
  if (current == index - 1) {
    // Remove 'n.next'.
    n.next = n.next.next; 
  } else {
    remove(index, current + 1, n.next);
  }
}