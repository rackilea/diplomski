public class RateDeserializer extends StdDeserializer<Rate> {

    static final String VALUE_NODE_NAME = "value";
    static final String RATESUBTYPE_NODE_NAME = "rateSubType";

    public RateDeserializer() {
        super(Rate.class);
    }

    @Override
    public Rate deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException {

        ...

    }
}