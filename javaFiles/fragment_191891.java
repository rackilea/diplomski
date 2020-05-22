// Individual collectors are defined here
List<Collector<Person, ?, ?>> collectors = Arrays.asList(
        Collectors.averagingInt(Person::getAge),
        Collectors.summingInt(Person::getAge));

@SuppressWarnings("unchecked")
Collector<Person, List<Object>, List<Object>> complexCollector = Collector.of(
    () -> collectors.stream().map(Collector::supplier)
        .map(Supplier::get).collect(toList()),
    (list, e) -> IntStream.range(0, collectors.size()).forEach(
        i -> ((BiConsumer<Object, Person>) collectors.get(i).accumulator()).accept(list.get(i), e)),
    (l1, l2) -> {
        IntStream.range(0, collectors.size()).forEach(
            i -> l1.set(i, ((BinaryOperator<Object>) collectors.get(i).combiner()).apply(l1.get(i), l2.get(i))));
        return l1;
    },
    list -> {
        IntStream.range(0, collectors.size()).forEach(
            i -> list.set(i, ((Function<Object, Object>)collectors.get(i).finisher()).apply(list.get(i))));
        return list;
    });

Map<Integer, List<Object>> result = persons.stream().collect(
        groupingBy(Person::getGroup, complexCollector));