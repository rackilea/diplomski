JsonNode jsonNode = mapper.readTree(json);
if (jsonNode.isArray()) {
    for (JsonNode node : jsonNode) {
        ABC abc = mapper.convertValue(node, ABC.class);
        System.out.println("Data: " + abc.getA());
    }
}