ObjectMapper mapper = new ObjectMapper();
JsonNode rootNode = mapper.readTree(your_json_input);

JsnoNode resourcesNode = rootNode.path("resources");

for (JsonNode resourceNode : resourcesNode ) {
    if (resourceNode.isObject()) {
        // the node is an object, you could do POJO mapping now or keep using path() method to go deeper
    } else {
        // simply get the String value
        String list = resourceNode.getTextValue();
    }
}