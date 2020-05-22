public int indexOf(E element) {
  Node current = head;

  for (int i = 0; i < size; i++) {
    if (current.getmElement().equals(element)) {
      return i;
    }

    current= current.getmNextNode();
  }
  return -1;
}