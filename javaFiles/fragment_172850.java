static <T,U> boolean isBijection(Collection<T> c1,
                                 Collection<U> c2,
                                 BiPredicate<? super T, ? super U> pred) {
    Map<U, Long> freq = c2.stream()
                          .collect(Collectors.groupingBy(u -> u, Collectors.counting()));
    for (T t : c1) {
        Optional<U> ou = freq.keySet()
                             .stream()
                             .filter(u -> pred.test(t, u))
                             .findAny();
        if (ou.isPresent()) {
            freq.compute(ou.get(), (u, c) -> c == 1L ? null : c - 1L);
        } else {
            return false;
        }
    }

    return freq.isEmpty();
}