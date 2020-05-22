public Type removeAtTheIndex(int index) {
  // I want to return the data that was removed.
  Type theData = null;
  // Sanity checks.
  if (index >= 0 && index < size && start != null) {
    // Find the entry with the specified index.
    Node<Type> current = start;
    for (int i = 0; i < index && (current = current.getNext()) != null; i++) {
    }
    // Did we find it?
    if (current != null) {
      // Yes! Gather the contents.
      theData = current.getData();
      // Clear it.
      current.setData(null);
      // Special?
      if (current == start) {
        // Its the start one.
        start = start.getNext();
        // Detach it.
        start.setPrev(null);
      } else if (current == end) {
        // Step end back one.
        end = end.getPrev();
        // Detach it.
        end.setNext(null);
      } else {
        // Remove from within list.
        Node prev = current.getPrev();
        // Point it at my next.
        prev.setNext(current.getNext());
        // Point my next to new prev.
        current.getNext().setPrev(prev);
      }
      // One less now.
      size--;
    }
  }
  return theData;
}