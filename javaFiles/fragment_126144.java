List<Foo> result = list.stream().collect(Collectors.collectingAndThen(
    Collectors.groupingBy(
            o -> Arrays.asList(o.vacancy_id_1, o.vacancy_id_2),
            Collectors.toMap(o -> o.hId, o -> Arrays.asList(o.percent, o.golden))),
    m -> m.entrySet().stream().map(e -> new Foo(
            e.getKey().get(0), e.getKey().get(1),
            e.getValue().values().stream().mapToDouble(l->l.get(1))
                    .reduce((a,b)->{assert a==b; return a; }).getAsDouble(),
            e.getValue().entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, en->en.getValue().get(0)))
    )).collect(Collectors.toList())
));