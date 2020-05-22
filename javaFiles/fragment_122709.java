public class RetrieveChangeSetObjectDtoFactory {

    private Map<Class<?>, Map<Class<?>, BaseMapper<?, ?>>> entityDtoMappers = new HashMap<>();

    public <S, T> Object createDto(Class<S> entityClass, Class<T> dtoClass, S source) {
        if (source == null) {
            return null;
        }

        return getMapper(entityClass, dtoClass).toDto(source);
    }

    public <S, T> Object createSource(Class<S> entityClass, Class<T> dtoClass, T dto) {
        if (dto == null) {
            return null;
        }

        return getMapper(entityClass, dtoClass).toEntity(dto);
    }

    @SuppressWarnings("unchecked")
    protected <S, T> BaseMapper<S, T> getMapper(Class<S> entityClass, Class<T> dtoClass) {
        // appropriate checks
        return (BaseMapper<S, T>) entityDtoMappers.get(entityClass).get(dtoClass);
    }

    public <S, T> void registerMapper(Class<S> entityClass, Class<T> dtoClass, BaseMapper<S, T> mapper) {
        entityDtoMappers.computeIfAbsent(entityClass, key -> new HashMap<>()).put(dtoClass, mapper);
    }
}