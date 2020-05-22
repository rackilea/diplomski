public class MessageAdapter implements JsonDeserializer<Message> {

    private Map<String, Class<? extends Result>> ruleToResultClassMap;

    public MessageAdapter() {
        this.ruleToResultClassMap = new HashMap<String, Class<? extends Result>>();
        ruleToResultClassMap.put("73B5EEB4", DurationResults.class);
        ruleToResultClassMap.put("35B5EEB4", ErrorResults.class);
    }

    @java.lang.Override
    public Message deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject messageObject = json.getAsJsonObject();
        JsonArray bodyArray = messageObject.getAsJsonArray("body");

        List<Result> results = new ArrayList<Result>();
        for (JsonElement bodyElement : bodyArray) {
            JsonObject resultObject = bodyElement.getAsJsonObject();
            JsonObject ruleObject = resultObject.getAsJsonObject("rule");
            String ruleId = ruleObject.getAsJsonPrimitive("ruleid").getAsString();
            Class<? extends Result> resultClass = ruleToResultClassMap.get(ruleId);
            if (resultClass != null) {
                Result result = context.deserialize(resultObject, resultClass);
                results.add(result);
            } else {
                throw new IllegalArgumentException("Illegal ruleId: " + ruleId);
            }
        }
        return new Message(results, context.<Header>deserialize(messageObject.getAsJsonObject("header"), Header.class));
    }
}