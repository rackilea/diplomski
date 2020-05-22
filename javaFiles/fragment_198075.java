TreeMap<Integer, List<String>> res = list.stream()
    .collect(groupingBy(                           // compiler error
        s -> s.charAt(0) % 3,
        (Void x) -> new TreeMap<>(Comparator.reverseOrder()),
        Collectors.toList()
    ));