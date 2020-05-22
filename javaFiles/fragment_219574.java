@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    Route findByOrigin_IdAndDestination_Id(long originId, long destinationId);

}