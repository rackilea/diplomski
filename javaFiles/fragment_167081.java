class FamillyRelationshipsDeserializer extends JsonDeserializer<FamillyRelationships> {
    @Override
    public FamillyRelationships deserialize(JsonParser jp, DeserializationContext ctxt) throws 
            IOException, JsonProcessingException {
        FamillyRelationships relationships = new FamillyRelationships();
        JsonNode node = jp.readValueAsTree();
        JsonNode rels = node.get("familyRelationships");

        for (int i = 0; i < rels.size(); i++) {
            relationships.familyRelationships.add(new Relationship(rels.get(i));
        }

        return relationships;
    }
}