public interface PersonRepository extends CrudRepository<Persons, Long> {

    @Query("SELECT p FROM Persons where LOWER(p.firstname) like :key%"
            + " or LOWER(p.lastname) like :key%" )
    public List<Person> searchBy(@Param("word") String key);
}