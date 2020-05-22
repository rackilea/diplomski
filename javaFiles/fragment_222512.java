public class MyClassDeSerializer implements JsonDeserializer<MyClass> {
    @Override
    public MyClass deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        MyClass myClass = new MyClass();

        for (Map.Entry<String, JsonElement> property : jsonElement.getAsJsonObject().entrySet()) {
            if (property.getKey().contains("dynamic")) {
                myClass.setDynamic(property.getValue().getAsString());
            }
            else if (property.equals("hello")) {
                myClass.setHello(property.getValue().getAsString());
            }
            else if (property.getKey().equals("world")) {
                myClass.setWorld(property.getValue().getAsString());
            }
        }
        return myClass;
    }
}