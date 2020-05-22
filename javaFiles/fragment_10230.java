Map<String, List<Long>> uniqueSets = dataset.stream()
    .flatMap(m -> m.entrySet().stream())
    .collect(Collectors.groupingBy(
        Map.Entry::getKey,
        Collector.of(
            ArrayList<Long>::new,
            (list, item) -> list.addAll(item.getValue()),
            (left, right) -> { left.addAll(right); return left; })
    ));