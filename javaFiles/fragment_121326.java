public class MyBeanSerializer implements JsonSerializer<MyBean> {

    @Override
    public JsonElement serialize(MyBean myBean, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.add("map", context.serialize(new HashMap<String, String>(myBean)));
        object.add("city", context.serialize(myBean.city));
        return object;
    }

}