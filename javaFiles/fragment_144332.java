String json = "YOUR JSON HERE";
ObjectMapper mapper = new ObjectMapper();
Iterator<Entry<String, JsonNode>> fields = mapper.readTree(json).fields();
Map<String, String> m = new HashMap<>();
while (fields.hasNext()) {
    Entry<String, JsonNode> field = fields.next();
    m.put(field.getKey(), mapper.writeValueAsString(field.getValue()));
}
m.entrySet().forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));