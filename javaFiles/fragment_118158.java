private List<Foo> parseFooArray(JSONArray array) {

    List<Foo> list = new ArrayList<>();

    for (Object item : array) {
        JSONObject object = (JSONObject) item;
        Foo foo = new Foo();
        foo.setId(Integer.valueOf((String) object.get("ID")));
        foo.setObjects(parseObjectArray((JSONArray) object.get("Objects")));
        list.add(foo);
    }

    return list;
}