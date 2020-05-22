JsonReader reader = Json.createReader(new StringReader(input));
JsonObject response = reader.readObject();

JsonObject queueMessage =
    Json.createObjectBuilder()
        .add("event", "some event")
        .add("link", "some link")
        .add("details", response)
        .build();