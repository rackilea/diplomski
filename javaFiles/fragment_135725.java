public interface MyCrudRepo extends BaseCrudRepo<EntityClassName> {
    @Query(
        "SELECT ec FROM EntityClassName ec " +
        "WHERE ec.field1 = :param1 AND ec.field2 = :param2")
    List<EntityClassName> queryMethod(
        @Param("param1") String param1,
        @Param("param2") String param2,
        Pageable page
    ); 
}