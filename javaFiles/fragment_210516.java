public <C extends Collection<Integer>> C fillWithInt(Class<C> t, int from, int to) {
    return IntStream.range(from,to)
        .boxed()
        .collect(
            Collectors.toCollection(
                () -> {
                    try {
                        return t.newInstance();
                    } catch (InstantiationException | IllegalAccessException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            )
        );
}