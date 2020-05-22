public interface MyCollectionRepository extends PagingAndSortingRepository<MyCollectionClass, String> {
    @Query("{$where : ?0}")
    Page<MyCollectionClass> findSomething(String whereQuery, Pageable pageable);

     .....
}