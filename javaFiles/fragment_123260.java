public static void main(String[] args) throws Exception {
    String jsonString = "{\"property1\":\"someValue\", \"arrayProperty\":[{\"first\":1234, \"second\":-13.123}, {\"nested\":\"so deep\"}], \"finally\":\"last\"}";
    Gson gson = new Gson();
    JsonElement element = gson.fromJson(jsonString, JsonElement.class);
    System.out.println(element);
    JsonObject jsonObject = element.getAsJsonObject(); // should test type before you do this

    System.out.println(jsonObject.get("arrayProperty").getAsJsonArray().get(0));
}