@MappedSuperclass
public class AbstractJpaDao <T>{
    private Class<T> clazz;
    protected EntityManager entityManager;

    public final void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    @Transactional
    public T getById(final long id) {
        return entityManager.find(clazz, id);
    }
    //... all the others ...
}