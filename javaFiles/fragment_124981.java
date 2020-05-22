class WrapperDeserializer extends StdDeserializer<Wrapper> {

    public WrapperDeserializer() {
        this(null);
    }

    public WrapperDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Wrapper deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);


        String veryImportantProperty = node.get("veryImportantProperty").asText();
        List<Child> children = new ArrayList<Child>();
        int iChild = 1;
        Child child;
        while(node.has("child_"+iChild+"_name")) {
            child = new Child();
            child.setName(node.get("child_"+iChild+"_name").asText());
            child.setAge(node.get("child_"+iChild+"_age").asInt());
            children.add(child);
            iChild++;
        }

        Wrapper wrapper = new Wrapper();
        wrapper.setVeryImportantProperty(veryImportantProperty);
        wrapper.setChildren(children);
        return wrapper;
    }
}