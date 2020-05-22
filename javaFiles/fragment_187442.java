public boolean containsValue(@Nullable Object value) {
    for (Collection<V> collection : map.values()) {
      if (collection.contains(value)) {
        return true;
      }
    }

    return false;
}