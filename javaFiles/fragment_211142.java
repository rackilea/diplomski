fooList.stream().collect(
        Collectors.groupingBy(Foo::getName,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Foo::getValue)),
                        Optional::get
                )
        )
).values().forEach(System.out::println);