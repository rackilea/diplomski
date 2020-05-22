Map<Long, MapDifference> mapDifferences = input
  .stream()
  .map(h -> {
    Map<String, List<String>> left = object1 == null ? new LinkedTreeMap<>() : object1;
    Map<String, List<String>> right = object2 == null ? new LinkedTreeMap<>() : object2;
    MapDifference mapDifference = Maps.difference(left, right);
    return new AbstractMap.SimpleEntry<>((long) h.get("property"), mapDifference);
  })
  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));