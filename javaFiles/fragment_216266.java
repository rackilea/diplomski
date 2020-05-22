class CustomSchema implements DeserializationSchema {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public Map<String,Object> deserialize(byte[] bytes) throws IOException {
        Map<String,Object> t = null;
        t = mapper.readValue(bytes, Map.class);
        return t;
    }

    @Override
    public boolean isEndOfStream(Object o) {
        return false;
    }

    @Override
    public TypeInformation<Map> getProducedType() {
        return TypeInformation.of(new TypeHint<Map>() {
        });
    }
}