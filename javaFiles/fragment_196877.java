public static FooEnum fromValue(String v) {
    try {
        return valueOf(v);
    } catch (InvalidArgumentException e) {
        return FooEnum.UNKNOWN;
    }
}