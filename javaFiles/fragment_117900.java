public static <T, A, R> Collector<T, ?, List<R>> multiClassify(
        List<Predicate<T>> predicates, Collector<? super T, A, R> downstream) {
    Supplier<A> dsSupplier = downstream.supplier();
    BiConsumer<A, ? super T> dsAccumulator = downstream.accumulator();
    BinaryOperator<A> dsCombiner = downstream.combiner();

    Supplier<List<A>> supplier = () -> Stream.generate(dsSupplier)
            .limit(predicates.size()).collect(Collectors.toList());

    BiConsumer<List<A>, T> accumulator = (list, t) -> IntStream
            .range(0, predicates.size()).filter(i -> predicates.get(i).test(t))
            .forEach(i -> dsAccumulator.accept(list.get(i), t));

    BinaryOperator<List<A>> combiner = (l1, l2) -> IntStream.range(0, predicates.size())
            .mapToObj(i -> dsCombiner.apply(l1.get(i), l2.get(i)))
            .collect(Collectors.toList());

    Characteristics[] dsCharacteristics = downstream.characteristics().toArray(
            new Characteristics[0]);
    if (downstream.characteristics().contains(Characteristics.IDENTITY_FINISH)) {
        @SuppressWarnings("unchecked")
        Collector<T, ?, List<R>> result = (Collector<T, ?, List<R>>) (Collector<T, ?, ?>) 
            Collector.of(supplier, accumulator, combiner, dsCharacteristics);
        return result;
    }
    Function<A, R> dsFinisher = downstream.finisher();
    Function<List<A>, List<R>> finisher = l -> l.stream().map(dsFinisher)
           .collect(Collectors.toList());
    return Collector.of(supplier, accumulator, combiner, finisher, dsCharacteristics);
}