public boolean put(@Nullable K key, @Nullable V value) {
    Collection<V> collection = getOrCreateCollection(key);

    if (collection.add(value)) {
      totalSize++;
      return true;
    } else {
      return false;
    }
  }