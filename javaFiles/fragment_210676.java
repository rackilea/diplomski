class RepeatTest {
    final int nrOfIterations = 3;

    void test1(int runNr) {
        System.out.println("One #" + runNr);
    }

    void test2(int runNr) {
        System.out.println("Two #" + runNr);
    }

    @RepeatedTest(value = nrOfIterations)
    @TestFactory
    Stream<DynamicNode> factory(RepetitionInfo repetitionInfo) {
        final int runNr = repetitionInfo.getCurrentRepetition() - 1;
        return Stream.of(
                DynamicTest.dynamicTest("One", () -> test1(runNr)),
                DynamicTest.dynamicTest("Two", () -> test2(runNr))
        );
    }    
}