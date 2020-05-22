@NoRepositoryBean
public interface Dao<T extends BaseClass, E extends Serializable> extends
        CrudRepository<T, E> {

    Iterable<T> findByActive(Boolean active);

}