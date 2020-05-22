public static <T> Matcher<Iterable<? extends T>> containsInAnyOrder(T... items) {
    List<Matcher<? super T>> matchers = new ArrayList<Matcher<? super T>>();
    for (T item : items) {
        matchers.add(equalTo(item));
    }

    return new IsIterableContainingInAnyOrder<T>(matchers);
}