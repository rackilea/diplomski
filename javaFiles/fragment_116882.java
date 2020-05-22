@TestFactory
Stream<DynamicTest> dynamicTestsFromStream() throws IOException {
    initialize();

    return Arrays.stream(core) // Stream<Tuple4>
            .map(tuple -> DynamicTest.dynamicTest(
                    "test " + tuple.c,
                    () -> { Assert.assertTrue(false); }
    ));
}