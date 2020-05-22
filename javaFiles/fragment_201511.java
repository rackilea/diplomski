static <S, T> T map(S source, Function<S, T> mapFunction) {
  if (source == null) { // or again: Objects.requireNonNull(source,..)
    // throw exception due to source
  }
  T value = mapFunction.apply(source);
  if (value == null) { // or Objects.requireNonNull(value,..)
    // throw exception due to missing value
  }
  return value;
}