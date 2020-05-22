test.values().stream()
        .distinct()
        .collect(
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        lst -> IntStream.range(0, lst.size()).boxed().collect(
                                Collectors.toMap(i -> i + 1, i -> lst.get(i))
                        )
                )
        ).entrySet().forEach(System.out::println);

output:
 1=[1]
 2=[2]
 3=[3, 33]