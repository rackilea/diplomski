ObjectMapper mapper = new ObjectMapper();
ObjectNode root = (ObjectNode) mapper.readTree(jsonStr);
ObjectNode rootNew = mapper.createObjectNode();
for (int i = 0; i < root.get("Statement").size(); i++) {
    String date = root.get("Statement").get(i).get("date").asText().split(" ")[0];
    ObjectNode node = (ObjectNode) ((ObjectNode) root.get("Statement").get(i));
    node.remove("date");
    if (rootNew.has(date)) {
        ((ArrayNode) rootNew.get(date)).add(node);
    } else {
        rootNew.put(date, mapper.createArrayNode().add(node));
    }
}
System.out.println(rootNew.toString());