String output = str.chars()
    .boxed()
    .collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()))
    .entrySet()
    .stream()
    .flatMap(entry -> Stream.of(entry.getValue().toString(), Character.toString((char) entry.getKey().intValue())))
    .collect(Collectors.joining());