private static <T> Collection<List<T>> partition(List<T> list, int size) {
    final AtomicInteger counter = new AtomicInteger(0);

    return list.stream()
            .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size))
            .values();
}