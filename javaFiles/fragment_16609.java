class PersonSerializer implements JsonSerializer<Person> {
    @Override
    public JsonObject serialise(final Person src,
                                final Type personType,
                                final JsonSerializationContext context) {

        final JsonObject json = new JsonObject();
        final String[] names = src.getName().split(" ");
        // Some validation...

        json.addProperty("firstName", names[0]);
        json.addProperty("lastName", names[1]);
        return json;
    }
}