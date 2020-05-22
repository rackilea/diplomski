@Test
public void testGetIt() throws Exception {
    target = target.path("test");

    Response response = target.request().accept(MediaType.APPLICATION_JSON).get();
    String jsonResponse = response.readEntity(String.class);
    System.out.println(jsonResponse);

    String jsonPost = "{\n"
            + "    \"department\": \"Hard Knocks\",\n"
            + "    \"id\": \"1\",\n"
            + "    \"myEntries\": {\n"
            + "        \"key1\": \"value1\",\n"
            + "        \"key2\": \"valu2\"\n"
            + "    }\n"
            + "}";
    response = target.request().post(Entity.json(jsonPost));

    response.close();
}