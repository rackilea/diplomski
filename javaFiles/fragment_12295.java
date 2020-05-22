while (totalWeight > maxSegmentWeight) {
  ReferenceEntry<K, V> e = getNextEvictable();
  if (!removeEntry(e, e.getHash(), RemovalCause.SIZE)) {
    throw new AssertionError();
  }
}