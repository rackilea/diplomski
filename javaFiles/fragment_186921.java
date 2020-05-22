@Repository
    public interface UserRepository extends JpaRepository<User, Long> {

       @Query(value = "SELECT u FROM User u ORDER BY u.name DESC")
       List<User> getSortedUsers();

    }