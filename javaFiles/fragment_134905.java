ObjectMapper mapper = new ObjectMapper();
// Updated JSON in memory
ObjectNode rootNode = (ObjectNode)mapper.readTree(json);
ObjectNode activityDisplayModelNode = (ObjectNode)rootNode.path("activityDisplayModel");
JsonNode typeNode = activityDisplayModelNode.path("type");
activityDisplayModelNode.set("type", typeNode.path("id"));

System.out.println("Result: " + mapper.convertValue(rootNode, Root.class));