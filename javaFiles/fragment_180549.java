private void ensureCapacityHelper(int minCapacity) {
  int oldCapacity = elementData.length;
  if (minCapacity > oldCapacity) {
    Object[] oldData = elementData;
    int newCapacity = (capacityIncrement > 0) ?
        (oldCapacity + capacityIncrement) : (oldCapacity * 2);
    if (newCapacity < minCapacity) {
      newCapacity = minCapacity;
    }
    elementData = Arrays.copyOf(elementData, newCapacity);
  }
}