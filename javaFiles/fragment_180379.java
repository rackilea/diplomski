class ExampleTest {

    @ParameterizedTest
    @MethodSource("args")
    void test(String classParameter, String testParameter) {
        System.out.println(classParameter + " " + testParameter);
    }

    static Stream<Arguments> args() {
        return classParameters().flatMap(
                classParameter -> testParameters().map(
                        testParameter -> Arguments.of(classParameter, testParameter)));
    }

    static Stream<String> classParameters() {
        return Stream.of("classParam1", "classParam2");
    }

    static Stream<String> testParameters() {
        return Stream.of("testParam1", "testParam2");
    }

}