// Create the EnumMap
private final EnumMap<TestEnum, String> myEnumMap = new EnumMap<TestEnum, String>(TestEnum.class);
// Use an initialization block to put some values in it when an instance of EnumMapExample is created
{
    put(TestEnum.SOME_VALUE, "someValue");
    put(TestEnum.SOME_OTHER_VALUE, "someOtherValue");
}