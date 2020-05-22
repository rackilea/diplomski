@NoRepositoryBean
class BaseJpaRepositoryImpl<T, ID>
        extends SimpleJpaRepository<T, ID>
        implements BaseJpaRepository<T, ID> {

    public BaseJpaRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager em) {
        super(entityInformation, em);
    }

    // One of 'defined' methods inherited from SimpleJpaRepository (and in turn from JpaRepository)
    @Override
    public List<T> findAll() {
        //run some code here
        List<T> res = super.findAll();
        //run some code here
        return res;
    }

    // other 'defined' methods to intercept ...
}