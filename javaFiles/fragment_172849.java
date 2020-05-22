// INCORRECT
static <T,U> boolean isBijection(Collection<T> c1,
                                 Collection<U> c2,
                                 BiPredicate<? super T, ? super U> pred) {
    return c1.size() == c2.size() &&
           c1.stream().allMatch(t -> c2.stream()
                                       .anyMatch(u -> pred.test(t, u)));
}