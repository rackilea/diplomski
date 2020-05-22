Map<String, List<Obligation>> map =
    obligations.stream() // Stream<Obligation>
               .flatMap(o -> o.getLicenseIDs()
                              .stream()
                              .map(id -> new SimpleEntry<>(o,id))) // Stream<Map.Entry<Obligation,String>>
               .collect(Collectors.groupingBy(Map.Entry::getValue,
                                              Collectors.mapping(Map.Entry::getKey,
                                                                 Collectors.toList())));