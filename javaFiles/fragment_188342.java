public class MyCustomizedCassandraRepository<T>
                            extends SimpleCassandraRepository<T, MapId>
                            implements MyCassandraRepository<T> {

    public MyCustomizedCassandraRepository(CassandraEntityInformation<T, MapId> metadata,
                                                    CassandraOperations operations) {
        super(metadata, operations);
    }

    public T save(T entity, WriteOptions options) {

        System.out.println(String.format("Called MyCustomizedCassandraRepository.save(%s, %s)", 
                                             entity, options));
        return entity;
    }
}