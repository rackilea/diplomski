private Node remove(int index, Node n) {
  if (n == null || index < 0) {
    throw new IndexOutOfBoundsException();
  }
  if (index == 0) {
    // Remove 'n' and return the rest of the list.
    return n.next; 
  }
  // 'n' stays. Update the rest of the list and return it.
  n.next = remove(index - 1, n.next);
  return n;
}