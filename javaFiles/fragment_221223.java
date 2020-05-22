private static Map<String, Object> fillHashMap(JsonNode rootNode) throws Exception {
    Map<String, Object> elementsMap = new HashMap<>();
    Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
    while (fieldsIterator.hasNext()) {
        Map.Entry<String, JsonNode> field = fieldsIterator.next();
        if (field.getValue().get("type").toString().contains("array")) {
            List<Map<String, Object>> objectArray = new ArrayList<>();
            JsonNode itemsNode = field.getValue().get("items").get("properties");
            objectArray.add(fillHashMap(itemsNode));
            elementsMap.put(field.getKey(), objectArray);
        } else if (field.getValue().get("type").toString().contains("object")) {
            elementsMap.put(field.getKey(), fillHashMap(field.getValue().get("properties")));
        } else {
            elementsMap.put(field.getKey(), field.getValue().get("default"));
        }
    }
    return elementsMap;
}