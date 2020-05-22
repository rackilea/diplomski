@Component
public class BigDecimalDeserializer extends StdDeserializer<BigDecimal> {

    public BigDecimalDeserializer() {
        super(BigDecimal.class);
    }

    @Override
    public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ...
    }

    ...

}