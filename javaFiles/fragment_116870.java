public class CustomStringDeserializer extends JsonDeserializer<String> {

@Override
public String deserialize(JsonParser jsonparser,
        DeserializationContext deserializationcontext) throws IOException,
        JsonProcessingException {

    return jsonparser.getText();

}

@Override
public String getNullValue() {
    return "";
}

}