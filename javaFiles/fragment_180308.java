class MyClass {
    ...
    @JsonValue
    private DateTime[] toValue() {
        return new DateTime[] {start, end};
    }
}