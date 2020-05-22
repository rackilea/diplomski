Map<String, Map<Boolean, Long>> result = T.stream()
    .collect(Collectors.groupingBy(
        input -> input.get(columnIndex),
        Collectors.partitioningBy(
            input -> "Yes".equals(input.get(input.size() - 1)),
            Collectors.counting())));