static void test(
      BiPredicate<Stream<Integer>, Predicate<Integer>> bipredicate, int val) {
    System.out.println(bipredicate.test(
         IntStream.rangeClosed(1, 5).boxed(), n -> n < val));
}

public static void main(String[] args) {
    test(Stream::allMatch, 10);
    test(Stream::allMatch, 4);
    test(Stream::anyMatch, 2);
    test(Stream::anyMatch, 0);
    test(Stream::noneMatch, 0);
    test(Stream::noneMatch, 5);
}