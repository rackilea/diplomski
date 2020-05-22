private static <T extends Collection<U>, U extends Number> T getCollection(
        Supplier<T> supplier, Function<Number, U> fn) {
        int count = RND.nextInt(COUNT_MAX);
        return RND.ints().limit(count).boxed().map(fn)
            .collect(Collectors.toCollection(supplier));
    }