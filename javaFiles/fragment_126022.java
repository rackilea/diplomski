@Repository
public interface TestRepo  extends JpaRepository<Question, Long>{
    @Modifying
    @Query(value = "delete from testmodel c where c.id in ?1 and c.name=?2",
            nativeQuery = true)
    void deleteModel(List<Long> ids, String text);
}