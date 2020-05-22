interface ProductRepository extends Repository<Product, Long> {

@EntityGraph(attributePaths = {"tags"})
@Query("SELECT p FROM Product p WHERE p.id=:id")
Product findOneByIdWithEntityGraphTags(@Param("id") Long id);
}