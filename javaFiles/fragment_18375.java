ObjectMapper mapper = new ObjectMapper();
JsonNode node = mapper.readTree(jsonFile);

List<JsonNode> segments = node.findValues("segments");
for (JsonNode segment : segments) {
    List<JsonNode> flightSegments = segment.findValues("flightSegment");
    System.out.println(flightSegments.size());
}