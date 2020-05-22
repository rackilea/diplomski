List<Foo> result = list.stream().collect(Collectors.collectingAndThen(
    Collectors.groupingBy(
        o -> new UnorderedPair<>(o.vacancy_id_1, o.vacancy_id_2),
            pairing(
                Collectors.toMap(o -> o.hId, o -> o.percent),
                Collectors.reducing(null, o -> o.golden,
                    (a,b) -> {assert a==null || a.doubleValue()==b; return b; }),
            (m,golden) -> new AbstractMap.SimpleImmutableEntry<>(m,golden))),
    m -> m.entrySet().stream().map(e -> new Foo(
        e.getKey().a, e.getKey().b, e.getValue().getValue(), e.getValue().getKey()))
    .collect(Collectors.toList())
));