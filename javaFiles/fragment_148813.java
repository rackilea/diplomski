@Bean
  public Map<ObjectType, List<Action>> getMap() {

    Map<ObjectType, List<Action>> map = new HashMap<>();
    fillMap()

    return map;
  }