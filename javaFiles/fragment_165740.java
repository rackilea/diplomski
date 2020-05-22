public static <T> T find(Collection<T> collection, T example) {
  for (T element : collection) {
    if (element.equals(example)) {
      return element;
    }
  }
  collection.add(example);
  return example;
}