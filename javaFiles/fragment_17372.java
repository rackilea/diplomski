public static <T> Predicate<T> combineFilters(List<Predicate<T>> filters) {
    return filters.stream().reduce(Predicate::and).orElse(x -> true);
}

public static <T> Predicate<T> combineFilters(List<Predicate<T>> filters) {
    return filters.stream().reduce(Predicate::or).orElse(x -> true);
}