@Transactional
public interface ParentEntityRepository extends JpaRepository<ParentEntity, Long> {

    @Query("delete from ParentEntity p where p.created < :date) 
    void deleteAllInBatchByCreatedBefore(Date date);

}