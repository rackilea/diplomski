public class WrapperSerializer extends StdSerializer<Wrapper> {
    public WrapperSerializer() {
        this(Wrapper.class);
    }

    protected WrapperSerializer(Class<Wrapper> t) {
        super(t);
    }

    @Override
    public void serialize(Wrapper value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeRaw(new StringBuilder()
                .append("<Key>")
                .append(value.getKey())
                .append("</Key>")
                .append("<Value>")
                .append(value.getValue())
                .append("</Value>")
                .toString());
    }
}