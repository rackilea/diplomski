public abstract class Mapper <Entity, DTO> {
    private static final MapperFactory mapperFactory = MapperFactory.getInstance();
    public Mapper() {
        mapperFactory.registerMapper(getEntityClass(), getDTOClass(),this);
    }

    public abstract Entity map(DTO object);
    public abstract DTO mapReverse(Entity object); 

    public abstract Class<Entity> getEntityClass();
    public abstract Class<DTO> getDTOClass();
}

public class MapperFactory {
    private Map<String, Mapper> mappers = new ConcurrentHashMap<>(); //MapperFactory is a singleton class, ConcurrentHashMap ensures thread safety.         

    private static final MapperFactory INSTANCE = new MapperFactory();

    public static MapperFactory() {
        return MapperFactory.INSTANCE;
    }

    public <Entity, DTO> void registerMapper(Class<Entity> entityClass, Class<DTO> dtoClass, Mapper<Entity, DTO> mapper) {
        mappers.put(dtoClass.getCanonicalName(), mapper);
        mappers.put(entityClass.getCanonicalName(), mapper);
    }

    public <T> Mapper getMapper(Class<T> sourceClass) {
         mappers.get(sourceClass.getCanonicalName());
    }
}