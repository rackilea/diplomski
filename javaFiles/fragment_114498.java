private JsonNode getNodeFunc4(JsonNode parentNode) {
    return Stream.of("/foo", "/bar")
                 .map(JsonPointer::compile)
                 .map(parentNode::at)
                 .filter(Predicate.not(JsonNode::isMissingNode))
                 .findFirst()
                 .orElse(parentNode);
}