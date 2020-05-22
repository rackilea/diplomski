@NoRepositoryBean
public interface PublishableEntityRepository<T, ID extends Serializable>
       extends PagingAndSortingRepository<T, ID> {
    @PostFilter("hasPermission(filterObject, 'read')")
    List<T> findAll();

    @PostAuthorize("hasPermission(returnObject, 'read')")
    T findOne(ID id);

    // where entity.status is PUBLISHED or security SpEL with hasRole
    @Query("select o from #{#entityName} o where o.status = 'PUBLISHED' " +
        "or 1 = ?#{security.hasRole('ROLE_ADMIN') ? 1 : 0}")
    Page<T> findAll(Pageable var1);
}