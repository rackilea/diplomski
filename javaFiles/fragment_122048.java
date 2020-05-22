static class TestClass {
    public int id;
    public String name;
}

@Test
public void gson() {
    Gson gson = new Gson();
    TestClass[] item = gson.fromJson("[{'id': 1, 'name': 'testclass'}]", TestClass[].class);
    assertThat(item[0].id, is(1));
    assertThat(item[0].name, is("testclass"));
    assertThat(item.length, is(1));
}

@Test
public void jackson() throws IOException {
    ObjectMapper jacksonObjectMapepr = new ObjectMapper();
    TestClass[] item = jacksonObjectMapepr.readValue("[{\"id\": 1, \"name\": \"testclass\"}]", TestClass[].class);
    assertThat(item[0].id, is(1));
    assertThat(item[0].name, is("testclass"));
    assertThat(item.length, is(1));
}