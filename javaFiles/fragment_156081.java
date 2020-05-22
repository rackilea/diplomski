final ObjectMapper mapper = new ObjectMapper();
final JsonNode input = mapper.readTree(yourSourceHere);

Map.Entry<String, JsonNode> entry;

final Iterator<Map.Entry<String, JsonNode>> iterator
    = input.get("List").get("Summary").fields();

while (iterator.hasNext()) {
    entry = iterator.next();
    // work with entry
}