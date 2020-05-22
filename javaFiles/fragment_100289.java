@Validate
public interface FooJpaRepository extends JpaRepository<Foo, Long> {

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    List<Foo> findByBar(@Size(max = 16) String bar);
}