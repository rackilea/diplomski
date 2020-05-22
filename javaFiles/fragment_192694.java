final class One {
  void one() {
    Stream<Optional<Integer>> optionalStream = Stream.of(Optional.empty());
    List<Optional<Integer>> optionalList = optionalStream.collect(Collectors.toList());
  }
}

final class Two {
  void two() {
    List<Optional<Integer>> optionalList1 =
        Stream.of(Optional.empty()).collect(Collectors.toList());
  }
}