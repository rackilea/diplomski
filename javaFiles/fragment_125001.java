static <T> boolean setIfEqualTo(AtomicReference<T> ref, T old, T value) {
  T current;
  do {
    current = ref.get();
    if (!Objects.equals(current, old)) {
      // They're not equal, so give up on trying to update.
      return false;
    }
  } while (
      // Try to update, if the value is still equal to `current`.
      !ref.compareAndSet(current, value));
  return true;
}