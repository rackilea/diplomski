public abstract class AbstractRepository<T> {

    protected final Class<T> entityClass;

    protected AbstractRepository() {
        // Don't remember if this reflection stuff throws any exception
        // If it does, try-catch and throw RuntimeException 
        // (or assign null to entityClass)
        // Anyways, it's impossible that such exception occurs here
        Type t = this.getClass().getGenericSuperclass();
        this.entityClass = ((Class<T>)((ParameterizedType)t).getActualTypeArguments()[0]);
    }

    T getEntityFromDBObject(DBObject object) {
        // Use reflection to create an entity instance
        // Let's suppose all entities have a public no-args constructor (they should!)
        T entity = (T) this.entityClass.getConstructor().newInstance();

        // Now fill entity with DBObject's data
        // This is the place to fill common fields only, i.e. an ID
        // So maybe T could extend some abstract BaseEntity that provides setters for these common fields
        // Again, all this reflection stuff needs to be done within a try-catch block because of checked exceptions
        // Wrap the original exception in a RuntimeException and throw this one instead
        // (or maybe your own specific runtime exception for this case)

        // Now let specialized repositories fill specific fields
        this.fillSpecificFields(entity, object);

        return entity;
    }

    protected abstract void fillSpecificFields(T entity, DBObject object);

}