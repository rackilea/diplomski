public class OkKoDeserializer extends StdScalarDeserializer<MYFLAGENUM> {
public OkKoDeserializer() {
    super(MYFLAGENUM.class);
}

@Override
public MYFLAGENUM deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    String value = p.getValueAsString();
    if ("VALUE_FALSE".equalsIgnoreCase(value)) {
        return MYFLAGENUM.KO;
    }
    if ("VALUE_TRUE".equalsIgnoreCase(value)) {
        return MYFLAGENUM.OK;
    }

    throw new IllegalArgumentException("value " + value + " is not parseable to a MYFLAGENUM");
}
}