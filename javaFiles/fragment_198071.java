TreeMap<Integer, List<String>> res = list.stream()
    .collect(Collectors.groupingBy(
        (String s) -> s.charAt(0) % 3,
        () -> new TreeMap<>(Comparator.reverseOrder()),
        Collectors.toList()
    ));