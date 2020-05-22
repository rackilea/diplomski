public class CustomSerializer  extends UnwrappingBeanSerializer {
    public CustomSerializer(BeanSerializerBase src, NameTransformer transformer) {
        super(src, transformer);
    }

    @Override
    public JsonSerializer<Object> unwrappingSerializer(NameTransformer transformer) {
        return new CustomSerializer(this, transformer);
    }

    @Override
    protected void serializeFields(Object bean, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
        A a = (A) bean;
        jgen.writeStringField("custom", a.getAProp());
        jgen.writeStringField("custom3", a.getAProp());
    }

    @Override
    public boolean isUnwrappingSerializer() {
        return true;
    }

}