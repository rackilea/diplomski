public static class EmployeeDeserializer extends JsonDeserializer<Employee> {

    @Override
    public Employee deserialize(JsonParser jp,
            DeserializationContext dc)
            throws IOException, JsonProcessingException {
        Employee emp = new Employee();
        JsonNode root = jp.getCodec().readTree(jp);
        emp.name = root.get("name").asText();
        emp.designation = root.get("designation").asText();
        JsonNode itemNode = root.get("item");
        if (itemNode.isArray()) {
            ArrayNode itemsNode = (ArrayNode) itemNode;
            List<Item> items = new ArrayList<>();
            for (JsonNode iNode : itemsNode) {
                Item item = new Item();
                item.name = iNode.get("name").asText();
                item.desc = iNode.get("desc").asText();
                items.add(item);
            }
            emp.items = items;
        } else if (itemNode.isObject()) {
            List<Item> items = new ArrayList<>();
            Item item = new Item();
            item.name = itemNode.get("name").asText();
            item.desc = itemNode.get("desc").asText();
            items.add(item);
            emp.items = items;
        } else {
            String item = root.get("item").asText();
            emp.item = item;
        }
        return emp;
    }
}