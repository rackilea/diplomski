/**
 * @throws NoSuchElementException
 */
public static <T> T getOne(Iterable<T> iterable) {
  Iterator<T> iterator = iterable.iterator();
  if (iterator instanceof AutoCloseable) {
    try (AutoCloseable c = (AutoCloseable) iterator) {
      return iterator.next();
    }
  } else {
    return iterator.next();
  }
}