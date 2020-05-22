// Find the next free element and mark it not free.
  private Node<T> getFree() {
    Node<T> freeNode = head.get();
    int skipped = 0;
    // Stop when we hit the end of the list
    // ... or we successfully transit a node from free to not-free.
    // This is the loop that could cause delays under hight thread activity.
    while (skipped < capacity && !freeNode.free.compareAndSet(true, false)) {
      skipped += 1;
      freeNode = freeNode.next;
    }
    // ...
  }