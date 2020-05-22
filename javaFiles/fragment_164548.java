@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT COUNT(p) FROM Product p WHERE p.title=?1")
    Long countByTitle(String title);

    @Query("SELECT p FROM Product p WHERE p.title LIKE :title AND visible=true")
    List<Product> findByTitleLikeAndVisibleTrue(@Param("title") String title);
}