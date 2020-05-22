static <T> T mapIfNotNull(T value) {
  if (value == null) {
    // throw your exception...
  }
  return value;
}