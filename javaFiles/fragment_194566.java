private static IntStream getSingleIntStream(List<String> list) {
    final AtomicInteger atomicInteger = new AtomicInteger();
    return list.stream()
            .flatMapToInt(str -> {
                atomicInteger.incrementAndGet();
                return IntStream.range(0, str.length())
                        .map(i -> atomicInteger.get());
            });
}