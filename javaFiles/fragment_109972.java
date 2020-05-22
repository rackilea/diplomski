public class ResponseSerializer extends JsonSerializer<ResponseValues>{ 

    @Override
    public void serialize(ResponseValues responseValues, JsonGenerator gen,
            SerializerProvider provider) throws IOException,
            JsonProcessingException {

        gen.writeString(responseValues.getStringValue());
    }

}