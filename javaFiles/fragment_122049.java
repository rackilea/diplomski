@Test
public void sillyWayIDontRecommend() throws NoSuchFieldException, IllegalAccessException {
    TestClass[] item = new TestClass[1];

    JsonArray array = new JsonParser().parse("[{\"id\": 1, \"name\": \"testclass\"}]").getAsJsonArray();
    for(int i = 0; i<array.size(); i++) {
        item[i] = new TestClass();

        JsonObject object = array.get(i).getAsJsonObject();
        for(Map.Entry<String, JsonElement> entry : object.entrySet()) {
            Field field = TestClass.class.getDeclaredField(entry.getKey());
            if(field.getType().equals(int.class)) {
                field.setInt(item[i], entry.getValue().getAsInt());
            } else {
                field.set(item[i], entry.getValue().getAsString());
            }
        }
    }

    assertThat(item[0].id, is(1));
    assertThat(item[0].name, is("testclass"));
    assertThat(item.length, is(1));
}