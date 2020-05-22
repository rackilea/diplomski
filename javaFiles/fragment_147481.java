@JsonSerialize(using = SubjectAutocompleteSerializer.class)
public class PreferenceEntity {
    ...
        public static class SubjectAutocompleteSerializer extends JsonSerializer<PreferenceEntity> {

            public void serialize(PreferenceEntity value, JsonGenerator jgen,
                          SerializerProvider provider) throws IOException,
                JsonProcessingException {

                jgen.writeStartObject();
                if (value.name != null && !value.name.isEmpty()) {
                    jgen.writeStringField("name", value.name);
                }
                if (value.getType() != null && !value.getType().isEmpty()) {
                    jgen.writeStringField("type", value.getType());
                }
                for (Entry<String, String> entry : value.getAttributes().entrySet()) {
                    jgen.writeStringField(entry.getKey(), entry.getValue());
                }
                jgen.writeObjectField("children", value.getChildren());

                jgen.writeEndObject();
            }
    }
}