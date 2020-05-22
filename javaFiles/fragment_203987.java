public class ErrorMessageConverter implements JsonDeserializer<List<ErrorMessage>> {
    public List<ErrorMessage> deserialize(JsonElement json, Type typeOfT,
                                          JsonDeserializationContext ctx) {
        List<ErrorMessage> vals = new ArrayList<ErrorMessage>();
        if (json.isJsonPrimitive()) {
            // handle your first case, for example:
            ErrorMessage err = new ErrorMessage(json.getAsString());
            vals.add(err);
            // in this case you will have a List which contains only one element - your String-only error
        } else if (json.isJsonObject()) {
            // handle your second case
            JsonArray errors = json.getAsJsonObject().get("errors").getAsJsonArray();
            // work with errors - parse it to a List<ErrorMessage>
            // you have to manually iterate over array's elements and parse it one by one to avoid an inifinit loop (if you try parsing it as a List, Gson will call your converter again)
            for (JsonElement e : json.getAsJsonArray()) {
                vals.add(ctx.deserialize(e, ErrorMessage.class));
            }
        }
        return vals;
    }
}

class ErrorMessage {
    int code;
    String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}