public Pojo deserialize(JsonParser jParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    ObjectCodec oc = jp.getCodec();
    JsonNode node = oc.readTree(jp);

    Iterator<JsonNode> iterator = node.iterator();
    List<Pojo> pojos = new ArrayList<Pojo>();

    while (iterator.hasNext()) {
        JsonNode next = iterator.next();
        pojos.add(
            new Pojo(
                next.get("attribute1"),
                next.get("attribute2")));
    }

    return pojos;
}