@RepositoryRestResource(path = "people", rel = "people")
interface PersonRepository extends CrudRepository<Person, Long> {

  @Override
  @RestResource(exported = false)
  void save(Person person);

}