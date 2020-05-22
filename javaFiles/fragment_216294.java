public class OkJsonConverter {

private static final String ERROR_CODE_FIELD_NAME = "error_code";

protected <T> T readTreeToValue(String json, TypeReference<T> valueTypeRef) throws OkClientException {
    T object = null;

    ObjectMapper objectMapper = new ObjectMapper();
    try {
        JsonNode jsonNode = objectMapper.readTree(json);

        if (jsonNode.has(ERROR_CODE_FIELD_NAME)) {
            Error error = objectMapper.treeToValue(jsonNode, Error.class);
            throw new OkClientException("Ok API returned error", error);
        } else {
            JavaType type = objectMapper.getTypeFactory().constructType(valueTypeRef);
            object = objectMapper.convertValue(jsonNode, type);
        }
    } catch (IOException e) {
        throw new OkClientException("Unable to process JSON", e);
    }

    return object;
}