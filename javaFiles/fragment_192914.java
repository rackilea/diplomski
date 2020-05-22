Map<String, Optional<Integer>> result = entities.stream()
  .collect(groupingBy(Entity::getCode,
    collectingAndThen(maxBy(Comparator.comparingInt(Entity::getVersion)),
      opEntity -> opEntity.map(Entity::getVersion))));

System.out.println(result);
// {code2=Optional[2], code1=Optional[3]}