public class QuestionSerializer extends JsonSerializer<Question> {
    @Override
    public void serialize(Question value, JsonGenerator jgen, SerializerProvider provider) 
      throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeNumberField("id", value.getId());
        jgen.writeStringField("question_title", value.getQuestionTitle());
        jgen.writeStringField("question_desc", value.getQuestionDesc());
        jgen.writeNumberField("required_question_id", value.getRequiredQuestion().getId());
        jgen.writeEndObject();
    }
}