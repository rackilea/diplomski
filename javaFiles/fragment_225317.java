JsonNode jsonNode = mapper.readTree(json);
if (jsonNode.isArray()) {
    for (JsonNode node : jsonNode) {
        String nodeContent = mapper.writeValueAsString(node);
        ABC abc = mapper.readValue(nodeContent, ABC.class);

        System.out.println("Data: " + abc.getA());
    }
}