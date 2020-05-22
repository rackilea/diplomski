public static Optional<MyEnum> fromStringOptional(String text) {
    try {
        return Optional.of(MyEnum.valueOf(text));
    } catch (IllegalArgumentException|NullPointerException e) {
        return Optional.empty();
    }
}