for (JsonPointer jsonPointer : jsonPointers) {
    JsonNode kid = parentNode.at(jsonPointer);
    if (!kid.isMissingNode()) {
         return kid;
    }
}