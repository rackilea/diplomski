@Repository
public interface PersonRepository extends JpaRepository <Person, Long> {

    @Query(
        value = "select p from Person p join p.addresses ad group by p Order By addressCount asc",
        countQuery = "select count(p) from Person p"
    )
    Page<Person> findAllOrderByAddressCountAsc(Pageable pageable);

    @Query(
        value = "select p from Person p join p.addresses ad group by p Order By addressCount desc",
        countQuery = "select count(p) from Person p"
    )
    Page<Person> findAllOrderByAddressCountDesc(Pageable pageable);
}