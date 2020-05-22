vehicleList.stream()
  .flatMap(v -> v.getRegionList()
       .stream()
       .map(r -> new AbstractMap.SimpleImmutableEntry<>(v, r)))
  .forEach(e -> {
    Vehicle key = e.getKey();
    Region region = e.getValue();
  })