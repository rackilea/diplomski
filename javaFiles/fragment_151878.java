XmlMapper mapper = new XmlMapper();

    com.fasterxml.jackson.databind.node.ObjectNode rootNode = mapper.createObjectNode();
    ObjectNode currentNode = rootNode.putObject("Examples");
    currentNode
            .put("Puppy", true)
            .put("Apple", 2)
            .put("Jet", "Li");
    currentNode = rootNode.putObject("Single");
    currentNode.put("One", 1);

    String xml = mapper.writeValueAsString(rootNode);