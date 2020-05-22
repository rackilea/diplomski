JsonObject model = Json.createObjectBuilder()
                    .add("foo", "bar")
                    .add("boo", "baz")
                    .build();
    /* Write formatted JSON Output */
    Map<String, String> config = new HashMap<>();
    config.put(JsonGenerator.PRETTY_PRINTING, "");
    JsonWriterFactory factory = Json.createWriterFactory(config);

    StringWriter stWriterF = new StringWriter();
    try (JsonWriter jsonWriterF = factory.createWriter(stWriterF)) {
        jsonWriterF.writeObject(model);
    }
    System.out.println(stWriterF);