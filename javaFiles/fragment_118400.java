@Repository
public interface StoreDataRepository extends JpaRepository<StoreDataRepository, Long> {

    @Trsansactional
    @Modifying
    @Query(value ="insert into store (id, name) values(:id, :name)", nativeQuery = true)
    public void storeData(@Param("id") int id, @Param("name") String name);