Map<String, String> valuesByKeyName = 
result.getAttributes().stream()
                      .collect(Collectors.toMap(k -> k.getKey().getName(), 
                               v -> v.getValue().getStringValue()));

String id = valuesByKeyName.get("pojoId");
String name = valuesByKeyName.get("pojoName");
String pojoValue = valuesByKeyName.get("pojoValue");

Pojo pojo = new Pojo(id, name, pojoValue);