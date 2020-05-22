@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface MyRepository extends JpaRepository<MyEntity, Long> {

    Stream<MyEntity> findMyEntityByStatusEquals(Status status);

    @Transactional(propagation = Propagation.MANDATORY)
    public <MyEntity> MyEntity save(MyEntity entity) {
      super.save(entity);
    }
}