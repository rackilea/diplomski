public <C extends Collection<Integer>> C fillWithInt(Supplier<C> supplier, 
    int from, int to){
    return IntStream.range(from,to)
        .boxed()
        .collect(Collectors.toCollection(supplier));
}