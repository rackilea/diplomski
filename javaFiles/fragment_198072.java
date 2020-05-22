static <X> X dummy(X x) { return x; }
…

TreeMap<Integer, List<String>> res = list.stream()
    .collect(Collectors.groupingBy(
        s -> s.charAt(0) % 3,
        dummy(() -> new TreeMap<>(Comparator.reverseOrder())),
        Collectors.toList()
    ));