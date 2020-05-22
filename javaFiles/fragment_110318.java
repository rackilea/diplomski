public class HtmlAdapter implements JsonDeserializer<String> {

    @Override
    public String deserialize(JsonElement json, Type typeOfT, 
                                  JsonDeserializationContext context)
        throws JsonParseException {
        return StringEscapeUtils.unescapeHtml4(json.getAsString());
    }

}