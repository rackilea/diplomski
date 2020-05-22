public static <T extends Comparable<?>> boolean areIdentical(Collection<ValueObject> vos, Function<ValueObject, T> voKeyExtractor, Collection<DTO> dtos, Function<DTO, T> dtoKeyExtractor) {
  return Arrays.equals(
    vos.stream()
      .map(voKeyExtractor)
      .sorted()
      .toArray(),
    dtos.stream()
      .map(dtoKeyExtractor)
      .sorted()
      .toArray()
  );
}