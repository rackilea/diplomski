public interface CounterRepository extends JpaRepository<Counter, Long>{

    @Modifying
    @Query(value = "UPDATE Counter SET value = LAST_INSERT_ID(value + 1) WHERE name = ?1", nativeQuery = true)
    int updateCounterByName(String name);

    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    int getLastInsertId();

    Counter findOneByName(String name);

}