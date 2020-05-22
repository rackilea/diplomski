@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUser_uid(Long uid);

}