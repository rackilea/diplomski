class MyJsonDeserializer implements JsonDeserializer<MyObject> {

    private final DaggerAppComponent singletonProvider;

    public MyJsonDeserializer(DaggerAppComponent componentProvdider) {
        this.singletonProvider = componentProvider;
    }

    public MyObject deserialize(JsonElement json, Type tye, JsonDeserializationContext context) throws JsonParseException {
        // you could here parse some arguments
        MyObject object =  ...
        singletonProvider.inject(object);
        return object;
    }
}