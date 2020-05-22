Map<String, Model> definitions = swagger.getDefinitions();
  for(Map.Entry<String, Model> e : definitions.entrySet()){
    Map<String, Property> propertyMap = e.getValue().getProperties();
    for(String key : propertyMap.keySet()){
      Property value = propertyMap.get(key);
      if(value.getType().equals("ref") && ((RefProperty) value).getSimpleRef().equals("LocalDateTime")){
        propertyMap.put(key, new StringProperty("LocalDateTime in ISO format")
                .example("dd-mm-yyyy")
                .pattern("pattern")
                .description("ISO format string"));
      }
    }
  }