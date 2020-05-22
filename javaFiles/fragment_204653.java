Map<String, Map<String, List<SomeClassB>>> someMap =
                someListOfClassA.stream()
                        .filter(...)
                        .collect(Collectors.groupingBy(SomeClassA::getSomeCriteriaA,
                                Collectors.groupingBy(SomeClassA::getSomeCriteriaB,
                                        Collectors.mapping(a -> getSomeClassBsFromSomeClassA(a),
                                                flatMapToImmutableList()))));