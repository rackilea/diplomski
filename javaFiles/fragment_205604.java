public static void main(String[] args) throws Exception {
    String jsonTemplate =
            "{\n" +
            "  \"value\": \"abc\",\n" +
            "  \"foo\": \"bar\",\n" +
            "  \"Treatments\": [ {\n" +
            "    \"value\": \"def\",\n" +
            "    \"Stages\": [ [ {\n" +
            "      \"value\": \"ghi\"\n" +
            "    } ] ]\n" +
            "  } ]\n" +
            "}";
    String jsonData = "{ \"abc\": {\n" +
            "    \"label\": \"Assembly name abc\",\n" +
            "    \"type\": \"STRING_TYPE abc\",\n" +
            "    \"format\": \"N\"\n" +
            "  },\n" +
            "  \"def\": {\n" +
            "    \"label\": \"Assembly name def\",\n" +
            "    \"type\": \"STRING_TYPE\",\n" +
            "    \"format\": \"N\"\n" +
            "  },\n" +
            "  \"ghi\": {\n" +
            "    \"label\": \"Assembly name ghi\",\n" +
            "    \"type\": \"STRING_TYPE\",\n" +
            "    \"format\": \"N\"\n" +
            "  }\n" +
            "}";


    JsonParser jsonParser = new JsonParser();
    JsonElement template = jsonParser.parse(jsonTemplate);
    JsonObject data = (JsonObject) jsonParser.parse(jsonData);

    JsonElement obj = template.deepCopy();//in case we don't want to modify original template

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    System.out.println(gson.toJson(traverse(obj, data)));

}