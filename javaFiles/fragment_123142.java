public static void main(String[] args) {
    Object1 o1 = new Object1();
    List<Interface1> list1 = new ArrayList<Interface1>();
    Interface1 f1 = new InterfaceImp();
    list1.add(f1);
    list1.add(f1);
    o1.field = list1;

    String s = getGsonWithAdapters().toJson(o1);
    System.out.println(s);
}

public static Gson getGsonWithAdapters() {
    GsonBuilder gb = new GsonBuilder();
    gb.serializeNulls();
    gb.registerTypeAdapter(Object1.class, new CustomAdapter());
    return gb.create();
}

public static class CustomAdapter implements JsonSerializer<Object1> {
    @Override
    public JsonElement serialize(Object1 obj, Type type,
            JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        Type t = new TypeToken<List<Interface1>>() {}.getType();
        jsonObject.add("field", new Gson().toJsonTree(obj.field, t));
        return jsonObject;
    }
}