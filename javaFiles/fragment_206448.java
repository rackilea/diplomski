static final EnumMapAnonSubclass<TestEnum, String> extends EnumMap<TestEnum, String> { // outer braces
    { // inner braces
    put(TestEnum.SOME_VALUE, "someValue");
    put(TestEnum.SOME_OTHER_VALUE, "someOtherValue");
    }
    // Implicitly created constructor
    EnumMapAnonSubclass(Class<? extends TestEnum> clazz) {
        super(clazz);
    }
};