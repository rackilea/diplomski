new EntityTemplate(new ContentProducer(
    (outputStream) -> {
        final JsonGenerator generator = new JsonFactory().createGenerator(outputStream);
        generator.write(...);
    }
));