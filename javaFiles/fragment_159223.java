SimpleModule module = new SimpleModule();
module.addDeserializer(Array.class, new StdDelegatingDeserializer<>(
    new StdConverter<Object[], Array>() {
        @Override
        public Array convert(Object[] value) {
            return new Array(value);
        }
}));

module.addSerializer(Array.class, new StdDelegatingSerializer(
    new StdConverter<Array, Object>() {
        @Override
        public Object convert(Array value) {
            return value.toArray();
        }
}));

ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(module);