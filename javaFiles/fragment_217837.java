private class PersonDeserializer implements JsonDeserializer<Person> {

  @Override
  public Person deserialize(JsonElement json, Type type,
        JsonDeserializationContext context) throws JsonParseException {

    JsonObject jobject = (JsonObject) json;

    Father father = new Father(jobject.get("father.name").getAsString());

    return new Person(jobject.get("name").getAsString(), father);
  }  
}