public class RankingValueDeserializer extends JsonDeserializer<RankingValue> {

    @Override
    public RankingValue deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        Integer key = node.get("key").asInt();
        Integer detail = node.get("aggregations").get("asMap").get("detail").get("value").asInt();
        Integer listed = node.get("aggregations").get("asMap").get("listed").get("value").asInt();
        return new RankingValue(key, detail, listed);
    }
}