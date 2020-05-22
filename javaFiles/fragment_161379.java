List<Map<Long, MapDifference>> mapDifferences = input
  .stream()
  .map(h -> {
    Map<String, List<String>> left = object1 == null ? new LinkedTreeMap<>() : object1;
    Map<String, List<String>> right = object2 == null ? new LinkedTreeMap<>() : object2;
    MapDifference mapDifference = Maps.difference(left, right);
    return Collections.singletonMap((long) h.get("property"), mapDifference);
  })
  .collect(Collectors.toList());