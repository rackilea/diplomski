Map<String, List<Long>> map = docs.flatMap(
            inner -> inner.collect(
                    Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream())
            .collect(Collectors.groupingBy(
                    Entry::getKey,
                    Collectors.mapping(Entry::getValue, Collectors.toList())));

System.out.println(map);

// {upto=[1], how=[1, 2], doing=[3], what=[2, 1], are=[1, 1], you=[1, 1]}