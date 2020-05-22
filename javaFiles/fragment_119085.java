private static GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(Bar.class, new JsonDeserializer<Bar>() {

    @Override
    public Bar deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {
        Bar result = new Bar();
        String regexp = "\"\\{\\\\\"key2_1\\\\\":\\\\\"(?s).*\\\\\".\\\\\"key2_2\\\\\":\\\\\"(?s).*\\\\\",\\\\\"key2_3\\\\\":\\\\\"(?s).*\\\\\"\\}\"";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(json.toString());
        String modifiedJsonStr = json.toString();
        if(matcher.matches()) {
            modifiedJsonStr = json.toString().replace("\"{", "{").replace("}\"", "}").replace("\\\"", "\"");
        }
        result = new Gson().fromJson(modifiedJsonStr, Bar.class);
        return result;
    }
});