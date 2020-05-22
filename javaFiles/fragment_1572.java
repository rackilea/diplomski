List<String> list = IntStream.range(0, s.length() - k + 1)
    .mapToObj((value) -> s.substring(value, value + k))
    .sorted(String.CASE_INSENSITIVE_ORDER)
    .collect(Collectors.toList());

smallest = list.get(0);
largest = list.get(list.size() - 1);