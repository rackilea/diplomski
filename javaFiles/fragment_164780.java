public static long[] toArray(Collection<? extends Number> collection) {
    if (collection instanceof LongArrayAsList) {
      return ((LongArrayAsList) collection).toLongArray();
    }

    Object[] boxedArray = collection.toArray();
    int len = boxedArray.length;
    long[] array = new long[len];
    for (int i = 0; i < len; i++) {
      // checkNotNull for GWT (do not optimize)
      array[i] = ((Number) checkNotNull(boxedArray[i])).longValue();
    }
    return array;
  }