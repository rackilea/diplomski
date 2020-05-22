@Transactional(readOnly = true)
@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {

    @Query("SELECT c FROM Citizen c WHERE c.idGame=?1")
    Citizen findByGameId(int gameId);
}