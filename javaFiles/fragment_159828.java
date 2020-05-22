private static <T> Predicate<T> andLogFilteredOutValues(Predicate<T> predicate, Consumer<T> action) {
    Objects.requireNonNull(predicate);
    Objects.requireNonNull(action);

    return value -> {
        if (predicate.test(value)) {
            return true;
        } else {
            action.accept(value);
            return false;
        }
    };
}