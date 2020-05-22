Map<Integer, List<Set<Integer>>> m2 = list.stream()
                .map(x -> x.stream().collect(Collectors.toMap(a -> a, b -> x)))
                .flatMap(x -> x.entrySet().stream())
                .collect(
                         Collectors.toMap(Map.Entry::getKey,
                         a -> List.of(a.getValue()), (l1, l2) -> Stream.concat(l1.stream(), l2.stream()).collect(Collectors.toList()))
                      );