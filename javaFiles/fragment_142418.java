private Map<Class<?>, Mapper<?>> mappers;

public <T> void addMapper(Class<T> outputType, Mapper<T> mapper) {
    mappers.put(outputType, mapper);
}

@SuppressWarnings("unchecked")
public <T> T getMapper(Class<T> outputType) {
    return (T) mappers.get(outputType);
}