Map<String, Set<Integer>> result = stringList.stream()
        .map(string -> string.split(":"))
        .collect(Collectors.toMap(
                 splitted -> splitted[0],
                 splitted -> Arrays.stream(splitted[1].split(","))
                                   .map(Integer::valueOf)
                                   .collect(Collectors.toCollection(LinkedHashSet::new)),
                 (s1, s2) -> { s1.addAll(s2); return s1; }));