private static <T> Predicate<T> andLogFilteredOutValues(Predicate<T> predicate) {
    return value -> {
        if (predicate.test(value)) {
            return true;
        } else {
            System.out.println(value);
            return false;
        }
    };
}