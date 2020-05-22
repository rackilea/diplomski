public static <T> boolean areIdentical(Collection<ValueObject> vos, Function<ValueObject, T> voKeyExtractor, Collection<DTO> dtos, Function<DTO, T> dtoKeyExtractor, Comparator<T> comparator) {
  return Arrays.equals(
    vos.stream()
      .map(voKeyExtractor)
      .sorted(comparator)
      .toArray(),
    dtos.stream()
      .map(dtoKeyExtractor)
      .sorted(comparator)
      .toArray()
  );
}