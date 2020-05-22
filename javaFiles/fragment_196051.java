@ParameterizedTest
@MethodSource("generateData")
void shouldGetDataBit(int first, String second, List<String> third) {
    System.out.println(first);
    System.out.println(second);
    System.out.println(third);
}

static Stream<Arguments> generateData() {
    return Stream.of(
        Arguments.of(1, "foo", Arrays.asList("a", "b", "c")),
        Arguments.of(2, "bar", Arrays.asList("x", "y", "z"))
    );
}