class JsonConverter {

    private ObjectMapper objectMapper = new ObjectMapper();
    private JsonFactory jsonFactory = new JsonFactory();

    public String convert(File sourceJsonFile) throws Exception {
        SourceEntity sourceEntity = parseSourceEntity(sourceJsonFile);
        List<Map<String, String>> result = convertToTargetPropertiesMap(sourceEntity);

        return objectMapper.writeValueAsString(result);
    }

    private SourceEntity parseSourceEntity(File sourceJsonFile)
            throws Exception {
        JsonParser parser = jsonFactory.createJsonParser(sourceJsonFile);
        return objectMapper.readValue(parser, SourceEntity.class);
    }

    private List<Map<String, String>> convertToTargetPropertiesMap(
            SourceEntity entity) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (String[][] pairs : entity.getRecords()) {
            list.add(createPropertyMap(entity.getColumns(), pairs[0]));
        }
        return list;
    }

    private Map<String, String> createPropertyMap(String[] names,
            String[] values) {
        Map<String, String> propertyMap = new LinkedHashMap<String, String>();
        for (int i = 0; i < values.length; i++) {
            propertyMap.put(names[i], values[i]);
        }
        return propertyMap;
    }
}