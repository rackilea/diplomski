Map<String, List<Integer>> result = stringList.stream()
        .map(string -> string.split(":"))
        .collect(Collectors.toMap(
                 splitted -> splitted[0],
                 splitted -> Arrays.stream(splitted[1].split(","))
                                   .map(Integer::valueOf)
                                   .collect(Collectors.toCollection(ArrayList::new)),
                 (l1, l2) -> { l1.addAll(l2); return l1; }));