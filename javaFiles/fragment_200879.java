public static final class NestedDeserializer extends StdDeserializer<MyClass.Nested>
    implements ResolvableDeserializer {
  private JsonDeserializer<Object> underlyingDeserializer;

  public NestedDeserializer() {
    super(MyClass.Nested.class);
  }

  @Override
  public void resolve(DeserializationContext ctxt) throws JsonMappingException {
    underlyingDeserializer = ctxt
        .findRootValueDeserializer(ctxt.getTypeFactory().constructType(MyClass.Nested.class));
  }

  @Override
  public Nested deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    JsonStreamContext ourContext = p.getParsingContext();
    JsonStreamContext listContext = ourContext.getParent();
    JsonStreamContext containerContext = listContext.getParent();
    MyClass container = (MyClass) containerContext.getCurrentValue();
    MyClass.Nested value = container.new Nested();
    // note use of three-argument deserialize method to specify instance to populate
    underlyingDeserializer.deserialize(p, ctxt, value);
    return value;
  }
}