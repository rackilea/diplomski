class JsonFileHandler<T> {

    private File file = new File("/Users/dambros/Desktop/test");
    private final Class<T> type;

    public JsonFileHandler(Class<T> type) {
        this.type = type;
    }

    public List<T> getList() {
        List<T> t;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        if (!file.exists()) {
            return null;
        } else {
            try {
                JavaType javaType = mapper.getTypeFactory().constructParametrizedType(ArrayList.class, List.class, type);
                t = mapper.readValue(file, javaType);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return t;
    }

}