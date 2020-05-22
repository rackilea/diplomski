String json = "{\"a\":1,\"b\":2,\"c\":3,\"d\":4,\"e\":5}";

ObjectMapper mapper = new ObjectMapper();
JsonNode tree = mapper.readTree(json);

ObjectNode node = mapper.createObjectNode();
node.set("b", tree.get("b"));
node.set("d", tree.get("d"));
node.set("e", tree.get("e"));

String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);