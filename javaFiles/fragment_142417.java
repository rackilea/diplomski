private static class MapperKey<T> {
    private final String key;

    public MapperKey(String key) {
        this.key = key;
    }
}

private Map<String, Object> mappers;

public static final MapperKey<CourseMapper> COURSE_KEY = new MapperKey<CourseMapper>("course");

public <T> void addMapper(MapperKey<T> mapperKey, T mapper) {
    mappers.put(mapperKey.key, mapper);
}

public <T> T getMapper(MapperKey<T> mapperKey) {
    Object mapper = mappers.get(mapperKey.key);
    // code for when mapper == null
    return (T) mapper;
}