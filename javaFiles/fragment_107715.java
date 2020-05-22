class MyJsonDeserializer implements JsonDeserializer<MyObject> {

    private final MyComponent singleton;

    public MyJsonDeserializer(MyComponent component) {
        this.singleton = component;
    }

    public MyObject deserialize(JsonElement json, Type tye, JsonDeserializationContext context) throws JsonParseException {
        // you could here parse some arguments
        return new MyObject(singleton);
    }
}