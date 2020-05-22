@Transactional
@Repository
public class FooRepoImpl extends GenericDAOImpl<Foo, Long> implements FooRepositiry {

    public FooRepoImpl() {
        super(Foo.class);
    }

    @Override
    public Foo findTextById(Long id) {
        CriteriaQuery<Foo> c = em.getCriteriaBuilder().createQuery(Foo.class);
        // .
        // .
        // .
        return em.createQuery(c).getSingleResult();
    }

}