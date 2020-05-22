ObjectMapper mapper = new ObjectMapper();
JsonNode rootNode = mapper.readTree(data);

JsonNode infoNode = rootNode.get("info");

Iterator<Map.Entry<String, JsonNode>> infoFieldsIterator = infoNode.fields();
while (infoFieldsIterator.hasNext()) {

    Map.Entry<String, JsonNode> field = infoFieldsIterator.next();
    System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());
}

JsonNode dataNode = rootNode.get("data");

for (int i = 0; i < dataNode.size(); i++) {
    JsonNode dataNodeNum = dataNode.get(i);
    Iterator<Map.Entry<String, JsonNode>> dataFieldsIterator = dataNodeNum.fields();
    while (dataFieldsIterator.hasNext()) {
        Map.Entry<String, JsonNode> field = dataFieldsIterator.next();
        System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());
    }
}