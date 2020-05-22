public class BasicObjectOptional {

    private Optional<String> someKey;
    private Optional<Integer> someNumber;
    private Optional<String> mayBeNull;

    public BasicObjectOptional() {
    }

    public BasicObjectOptional(boolean initialize) {
        if (initialize) {
            someKey = Optional.ofNullable("someValue");
            someNumber = Optional.ofNullable(42);
            mayBeNull = Optional.ofNullable(null);
        }
    }

    @Override
    public String toString() {
        return String.format("someKey = %s, someNumber = %s, mayBeNull = %s",
                                            someKey, someNumber, mayBeNull);
    }

}