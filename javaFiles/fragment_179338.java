Map<TypeId, Integer> r = stream.collect(
  groupingBy(Sample::getTypeId,
    Collectors.collectingAndThen(
      groupingBy(Sample::getType, summingInt(Sample::getQuantity)),
      map -> map.getOrDefault(SampleType.ADD, 0) - map.getOrDefault(SampleType.SUBTRACT, 0)
    )
  )
);