public class Wrapper {
    public Delivery delivery;
}

public class Delivery {
    @JsonDeserialize(using = ProviderResponseDeserializer.class)
    public ProviderResponse providerResponse;
}

public class ProviderResponse {
    public String sqsRequestId;
    public String sqsMessageId;
}

public class ProviderResponseDeserializer extends JsonDeserializer<ProviderResponse> {
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public ProviderResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return mapper.readValue(jsonParser.getText(), ProviderResponse.class);
    }
}