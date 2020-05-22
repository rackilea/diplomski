Map<String, DoubleSummaryStatistics> data = foos.stream()
                .collect(Collectors.groupingBy(Foo::getCode,
                                    Collectors.summarizingDouble(Foo::getPrice)));

List<FooB> fooBs = data.entrySet().stream()
        .map(e -> new FooB(e.getKey(), e.getValue().getSum(), e.getValue().getAverage()))
        .collect(toList());