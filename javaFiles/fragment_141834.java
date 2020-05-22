List<Foo> foos = Stream.of(new Foo("a", "b", 1), new Foo("a", "b", 2),
                 new Foo("a", "b", 3), new Foo("a", "bb", 3), new Foo("aa", "b", 3))
    .collect(Collectors.collectingAndThen(
        Collectors.toMap(x -> Arrays.asList(x.getA(), x.getB()), x -> x,
                         BinaryOperator.minBy(Comparator.comparing(Foo::getC))),
            map -> new ArrayList<>(map.values())));