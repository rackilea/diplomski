public interface CrudRepository<T, ID extends Serializable>
      extends Repository<T, ID> {

    Optional<T> findById(ID primaryKey);

  // .... other methods ...
}