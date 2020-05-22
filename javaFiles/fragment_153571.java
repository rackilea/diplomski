import org.codehaus.jackson.node.ObjectNode;
// ...
for (JsonNode personNode : rootNode) {
    if (personNode instanceof ObjectNode) {
        ObjectNode object = (ObjectNode) personNode;
        object.remove("familyName");
        object.remove("middleName");
    }
}