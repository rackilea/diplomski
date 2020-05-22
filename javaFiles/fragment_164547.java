@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Long countByTitle(String title);

    List<Product> findByTitleLikeAndVisible(String title, boolean visible);
}