@Transactional(readOnly = true)
public interface DealRepository extends JpaRepository<Deal, Long> {

    @Modifying
    @Transactional
    @Query("select d from Deal d where d.createdDate >= :from and d.createdDate <= :to ")
    List<Deal> findByCreatedDateBetween(@Param("from") Date from, @Param("to") Date to);