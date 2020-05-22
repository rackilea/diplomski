public ObjectNode toJson() {
    ObjectNode node = Json.newObject();
    node.put("yourDouble", doubleField);
    node.put("yourString", stringField);
    return node;
}