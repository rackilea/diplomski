class ExampleTest {

    static Stream<String> classParams() {
        return Stream.of("classParam1", "classParam2", "classParam3");
    }

    static Stream<Arguments> withClassParams(List<?> methodParams) {
        return classParams().flatMap(
                classParam -> methodParams.stream().map(
                        methodParam -> Arguments.of(classParam, methodParam)));
    }

    @ParameterizedTest
    @MethodSource
    void booleanParams(String classParam, boolean booleanParam) {
        System.out.println(classParam + " " + booleanParam);
    }

    static Stream<Arguments> booleanParams() {
        return withClassParams(List.of(false, true));
    }

    @ParameterizedTest
    @MethodSource
    void integerParams(String classParam, int integerParam) {
        System.out.println(classParam + " " + integerParam);
    }

    static Stream<Arguments> integerParams() {
        return withClassParams(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @MethodSource
    void objectParams(String classParam, Object objectParam) {
        System.out.println(classParam + " " + objectParam);
    }

    static Stream<Arguments> objectParams() {
        return withClassParams(List.of(new Object()));
    }

}