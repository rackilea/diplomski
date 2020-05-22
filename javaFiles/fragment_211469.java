Person socialButterfly = groupMap.values()
    .stream()
    .flatMap(Collection::stream)
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    .entrySet().stream()
    .max(Map.Entry.comparingByValue())
    .get().getKey();