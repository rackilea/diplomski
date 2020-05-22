@Repository
public interface PersonRepository extends CrudRepository<Person, String> {
    @Override
    @Query("select p from Person p join fetch p.organisation o")
    List<Person> findAll();
}