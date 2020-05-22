SimpleModule columnDefinitionModule = new SimpleModule("colDefMod", new Version(1, 0, 0, null))
      .addDeserializer(ColumnDefinition.class, new JsonDeserializer() {
           @Override
           public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException,  JsonProcessingException {
                // Need to read the type out and then use ObjectMapper to deserialize using the correct token
            }
        })
        .registerSubtypes(...); // add your subtypes here.

(new ObjectMapper()).registerModule(columnDefinitionModule);