test.entrySet().stream()
        .collect(
                Collectors.toMap(
                        Map.Entry::getValue,
                        x -> x,
                        (a, b) -> a
                )
        ).values()
        .forEach(System.out::println);