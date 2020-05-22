private List<Obj> parseObjectArray(JSONArray array) {

    List<Obj> list = new ArrayList<>();

    for (Object item : array) {
        JSONObject object = (JSONObject) item;
        Obj obj = new Obj();
        obj.setObjectID(Integer.valueOf((String) object.get("ObjectID")));
        list.add(obj);
    }

    return list;
}