public static String toPrettyFormat(String jsonString) {
    JsonParser parser = new JsonParser();
    JsonObject json = parser.parse(jsonString).getAsJsonObject();

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String prettyJson = gson.toJson(json);

    return prettyJson;
}