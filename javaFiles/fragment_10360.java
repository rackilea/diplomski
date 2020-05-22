@Repository
public interface UserRepositoryGenerated extends JpaRepository<User, Integer> {    
  @Query(
      value = "SELECT *     FROM users     WHERE id = :userId",
      nativeQuery = true
  )
  User findById(int userId);
}