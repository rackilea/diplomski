private JsonNode getNodeFunc3(JsonNode parentNode) {
    return Stream.of(JsonPointer.compile("/foo"), JsonPointer.compile("/bar"))
                 .map(parentNode::at)
                 .filter(Predicate.not(JsonNode::isMissingNode))
                 .findFirst()
                 .orElse(parentNode);
}