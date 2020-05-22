Set<Integer> set = IntStream.range(0, 10).boxed()
    .collect(Collectors.toCollection(TreeSet::new));
set.stream()
    .filter(i -> i > 5)
    .sorted()
    .forEach(set::remove);