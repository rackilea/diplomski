@Test
public void canParseToJson() {
    String json = "{\n" +
            "    \"file01\": {\n" +
            "        \"id\": \"0001\"\n" +
            "    },\n" +
            "    \"file02\": {\n" +
            "        \"id\": \"0002\"\n" +
            "    }\n" +
            "}";

    Configuration conf = Configuration.builder().jsonProvider(new GsonJsonProvider()).build();

    JsonObject file01 = JsonPath.using(conf).parse(json).read("$.file01");

    // prints out {"id":"0001"}
    System.out.println(file01);
}