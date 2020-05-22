public enum ExampleEnum {

    TRUE_CONDITION(42), FALSE_CONDITION(1);

    private final int value;

    private ExampleEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}