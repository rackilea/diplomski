public static <T> Optional<T> singleOrEmpty(Stream<T> stream) {
    return stream.limit(2)
        .map(Optional::ofNullable)
        .reduce(Optional.empty(),
             (a, b) -> a.isPresent() ^ b.isPresent() ? b : Optional.empty());
}

@Test
public void test() {
    testCase(Optional.empty());
    testCase(Optional.of(1), 1);
    testCase(Optional.empty(), 1, 1);
    testCase(Optional.empty(), 1, 1, 1);
}

private void testCase(Optional<Integer> expected, Integer... values) {
    Assert.assertEquals(expected, singleOrEmpty(Arrays.stream(values)));
}