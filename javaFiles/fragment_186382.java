Map<Integer, List<Set<Integer>>> m1 =
            list.stream().flatMap(Set::stream)
                .distinct()
                .collect(
                        Collectors.toMap(a -> a,
                                b -> list.stream().filter(set -> set.contains(b)).collect(Collectors.toList()))
                );