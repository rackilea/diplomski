private Map<String, Object> mappers;

public <T> T getMapper(String key, Class<T> mapperType) {
    Object mapper = mappers.get(key);
    // code for when mapper == null
    if (mapperType.isAssignableFrom(mapper)) {
        return (T) mapper;
    } else {
         // code for when mapper is of wrong type
    }
}