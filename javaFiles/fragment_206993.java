@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {

    @Query("select d from Deal d where d.active= true and d.employee.id = :employeeId")
    List<Deal> findActiveDeals(@Param("employeeId") long employeeId);
}