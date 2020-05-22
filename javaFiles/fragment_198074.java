TreeMap<Integer, List<String>> res = list.stream()
    .collect(groupingBy(
        s -> s.charAt(0) % 3,
        x -> new TreeMap<>(Comparator.reverseOrder()),
        Collectors.toList()
    ));