@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.user.uid = ?1")
    List<Post> findByUser(Long uid);

}