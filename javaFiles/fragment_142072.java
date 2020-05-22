SimpleDeserializers deserializers = new SimpleDeserializers();

deserializers.addDeserializer(Integer.class, new MyIntegerDeserializer(null));
deserializers.addDeserializer(Long.class, new MyLongDeserializer(null));

ObjectMapper mapper = new ObjectMapper().setDeserializerProvider(
            new StdDeserializerProvider().withAdditionalDeserializers(deserializers));

MyModel value = mapper.treeToValue(node, MyModel.class);