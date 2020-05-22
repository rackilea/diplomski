public static void main(String[] args) {
    JsonParser jsonParser = new JsonParser();
    String log = "[{\"car\": \"ford\"}, {\"car\": \"nissan\"}, {\"car\": \"bmw\"}]";
    JsonArray jsonObject = jsonParser.parse(log).getAsJsonArray();
    for (JsonElement jsonElement : jsonObject)
        System.out.println(jsonElement.getAsJsonObject().get("car").getAsString());

}