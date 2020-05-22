@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(
        value = "select p from Person p join p.addresses ad group by p",
        countQuery = "select count(p) from Person p"
    )
    Page <Person> findAllWithAddressCount(Pageable pageable);
}