public static <T> Matcher<Iterable<? extends T>> containsInAnyOrder(Matcher<? super T>... itemMatchers) {
    return containsInAnyOrder(Arrays.asList(itemMatchers));
}

public static <T> Matcher<Iterable<? extends T>> containsInAnyOrder(Collection<Matcher<? super T>> itemMatchers) {
    return new IsIterableContainingInAnyOrder<T>(itemMatchers);
}