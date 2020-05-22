@Bean(name = "customMap")
public Map<Integer, CustomEnumType> getCustomMap() {
  Map<Integer, CustomEnumType> map = new HashMap<>();
  map.put(1, CustomEnumType.type1);
  map.put(2, CustomEnumType.type2);
  //...
  return map;
}