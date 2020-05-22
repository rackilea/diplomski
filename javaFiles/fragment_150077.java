public Map<Long, String> getFieldEntityMapByType(String type) {
  List<FieldEntity> results = // call DAO and get list.
  Map<Long, String> map = new LinkedHashMap<>();
  for(FieldEntity entity : results) 
    map.put(entity.getFieldId(), entity.getFieldName());
  return map;
}