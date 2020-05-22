List<List<Map<String, String>>> result =  l.stream()
      .filter(m->m.containsKey("x"))    // filter map with `x` key
      .collect(Collectors.groupingBy(m->m.get("x").split("#")[1]))   // if map contains `x` as key then group by the value after `#`
      .entrySet().stream()
      .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))    //sort on requirement
      .map(Entry::getValue)
      .collect(Collectors.toList());