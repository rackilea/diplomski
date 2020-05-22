Map<Object, List<Object>> meInputs1 = Stream.of(inputArray1)
        .map(s -> s.split(":",2))
        .filter(s -> s.length >= 2) // ignore entries in inputArray1 without a ':'
        .collect(Collectors.groupingBy(s -> s[0],
                 Collectors.mapping(s -> s[1],
                 Collectors.toList())));