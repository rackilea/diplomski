Map<Long, String> map = 
    list.stream()
        .sorted(Comparator.comparing(Building::getName))
        .collect(Collectors.toMap(Building::getId,
                                  Building::getName,
                                  (v1,v2)->v1,
                                  LinkedHashMap::new));