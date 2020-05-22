private JsonNode getNodeFunc2(JsonNode parentNode) {
    return Stream.of(JsonPointer.compile("/foo"), JsonPointer.compile("/bar"))
                 .filter(i -> !parentNode.at(i).isMissingNode())
                 .findFirst()
                 .map(parentNode::at)
                 .orElse(parentNode);
}