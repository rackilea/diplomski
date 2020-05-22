class PersonJsonDeserializer implements JsonDeserializer<Person> {
    @Override
    public Person deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String type = json.getAsJsonObject().get("type").getAsString();
        switch(type) {
            case "zombie":
                return context.deserialize(json, Zombie.class);
            case "hunter":
                return context.deserialize(json, Hunter.class);
            default:
                throw new IllegalArgumentException("Neither zombie or hunter");
        }
    }
}