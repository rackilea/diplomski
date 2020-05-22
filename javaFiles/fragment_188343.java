@NoRepositoryBean
public interface MyCassandraRepository<T> extends CassandraRepository<T> {

    /**
     * Customized save method.
     */
     T save(T entity, WriteOptions options);
}