private void insert(ArrayList<T> heap, T element) {
  head.add(element);
  heapify(heap, heap.size() - 1);
}

private void heapify(ArrayList<T> heap, int location) {
  int parent = (location - 1) / 2; // -1 for zero-indexed language
  // same-element comparison is OK. This will always happen at the root.
  if (heap.get(parent).compareTo(heap.get(location)) > 0) {
    swap(heap, location, parent);
    heapify(heap, parent);
  }
}

private void swap(ArrayList<T> heap, int a, int b) {
  T temp = heap.get(a);
  heap.set(a, heap.get(b));
  heap.set(b, temp);
}