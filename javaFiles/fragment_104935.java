Optional<Supplier<String>> isEven(final int x) {
  if (x % 2 == 0) {
    return Optional.of(() -> x + " is even");
  } else {
    return Optional.empty();
  }
}