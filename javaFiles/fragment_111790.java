public class OldDeserializer extends StdDeserializer<Object> {
    OldDeserializer() {
        super(OldObject.class);
    }

    @Override
    public Object deserialize(
            final JsonParser parser,
            final DeserializationContext context) throws IOException {
        return parser.getCodec().readValue(parser, OldObject.class);
    }
}