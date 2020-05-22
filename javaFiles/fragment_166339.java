public static <T> Stream<List<T>> splitListStream(List<T> input, int batchSize) {
  if (batchSize <= 0)
    throw new IllegalArgumentException("batchSize must be positive (" + batchSize + ")");
  if (input.size() <= batchSize) return Stream.of(input);
  return IntStream.range(0, (input.size() + batchSize - 1) / batchSize)
          .mapToObj(i -> {
            int from = i * batchSize;
            int to = Math.min((i + 1) * batchSize, input.size());
            return input.subList(from, to);
          });
}