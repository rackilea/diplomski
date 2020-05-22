public class TeamDeserializer extends JsonDeserializer<Team> {

@Override
public Team deserialize(JsonParser jp, DeserializationContext ctxt) 
  throws IOException, JsonProcessingException {
    JsonNode node = jp.getCodec().readTree(jp);
    //read the node and set fields
    String name = node.get("name").asText();
    int id = (Integer) ((IntNode) node.get("id")).numberValue();
    //returning in required format
    return new Team(new Profile(name, id));
}
}