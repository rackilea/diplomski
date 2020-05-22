@Test
public void testParse() {
    String json = "{\n" +
            "  \"dataObject\": [\n" +
            "    {\n" +
            "      \"id\": 263626,\n" +
            "      \"role\": {\n" +
            "        \"id\": 12054,\n" +
            "        \"name\": \"Edit\",\n" +
            "        \"description\": \"\"\n" +
            "      },\n" +
            "      \"resource\": {\n" +
            "        \"id\": 5756,\n" +
            "        \"type\": \"resource\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 263364,\n" +
            "      \"role\": {\n" +
            "        \"id\": 12054,\n" +
            "        \"name\": \"Edit\",\n" +
            "        \"description\": \"\"\n" +
            "      },\n" +
            "      \"resource\": {\n" +
            "        \"id\": 5728,\n" +
            "        \"type\": \"resource\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    DocumentContext parse = JsonPath.parse(json);
    Object read = parse.read("$..[?((@.resource.id == 5756) && (@.role.name == 'Edit'))]");
    assertNotNull(read);
}