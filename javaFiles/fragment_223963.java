class PersonJsonDeserializer implements JsonDeserializer<Person> {
    @Override
    public Person deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String className = json.getAsJsonObject().get("type").getAsString();
        className = Character.toUpperCase(className.charAt(0)) + className.substring(1);
        try {
            return context.deserialize(json, Class.forName(className));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}