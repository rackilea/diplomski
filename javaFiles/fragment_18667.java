class AnswerDeserializer implements JsonDeserializer<Answer> {

    public Answer deserialize(JsonElement je, Type type, 
                              JsonDeserializationContext jdc) 
                                   throws JsonParseException {

        return new Answer(je.getAsJsonObject().get("answer")
                            .getAsJsonObject().get("text").getAsString());
    }

}