class CustomCarSerializer<T extends Car> extends StdSerializer<T> {

    public CustomCarSerializer(Class<T> clazz) {
        super(clazz);
    }

    @Override
    public void serialize(T value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {
        Manager<T> manager = new Manager<>(_handledType);
        jgen.writeString(manager.generateCustomCarName());
    }
}