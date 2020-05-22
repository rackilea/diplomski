static class MyCustom<T, U> implements Collector<Person, List<Person>, Map<T, List<U>>> {

    private final Function<Person, T> function;

    private final Predicate<Person> predicate;

    private final Function<Person, U> transformingFunction;

    public MyCustom(Predicate<Person> predicate, Function<Person, T> function,
            Function<Person, U> transformingFunction) {
        this.predicate = predicate;
        this.function = function;
        this.transformingFunction = transformingFunction;
    }

    @Override
    public Supplier<List<Person>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Person>, Person> accumulator() {
        return (list, person) -> {
            if (predicate.test(person)) {
                list.add(person);
            }
        };
    }

    @Override
    public BinaryOperator<List<Person>> combiner() {
        return (l1, l2) -> {
            l1.addAll(l2);
            return l1;
        };
    }

    @Override
    public Function<List<Person>, Map<T, List<U>>> finisher() {
        return list -> {
            return list.stream().collect(
                    Collectors.groupingBy(function, Collectors.mapping(transformingFunction, Collectors.toList())));
        };
    }

    @Override
    public Set<java.util.stream.Collector.Characteristics> characteristics() {
        return EnumSet.of(Characteristics.UNORDERED);
    }
}