public static void main(String[] args) throws Exception {
    SimpleModule module = new SimpleModule("WrapperModule", new Version(1, 0, 0, null));
    module.addSerializer(Wrapper.class, new WrapperSerializer(Wrapper.class));
    module.addDeserializer(Wrapper.class, new WrapperDeserializer(Wrapper.class));

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(module);

    Wrapper in = new Wrapper();
    in.elements = new String[]{"a", "b", "c"};

    String json = mapper.writeValueAsString(in);
    System.out.println(json);

    Wrapper out = mapper.readValue(json, Wrapper.class);
    System.out.println(Arrays.toString(out.elements));
}


public static class Wrapper {

    public String[] elements;

}

public static class WrapperSerializer extends StdSerializer<Wrapper> {

    public WrapperSerializer(Class<Wrapper> t) {
        super(t);
    }

    @Override
    public void serialize(Wrapper w, JsonGenerator gen, SerializerProvider provider) throws IOException {
        provider.defaultSerializeValue(w.elements, gen);
    }

}

public static class WrapperDeserializer extends StdDeserializer<Wrapper> {

    public WrapperDeserializer(Class<Wrapper> c) {
        super(c);
    }

    @Override
    public Wrapper deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
        Wrapper w = new Wrapper();
        w.elements = ctx.readValue(p, String[].class);
        return w;
    }
}