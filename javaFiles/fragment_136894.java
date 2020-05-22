@Repository
public class FooDAOImpl implements FooDAO {
    private FooHibernateDaoSupport hibernateDaoSupport;

    public FooDAOImpl() {
        // Init DaoSupport
    }

    @Override
    public Foo findById(final Serializable fooId) {
        StatelessSession session = hibernateDaoSupport.getSessionFactory().openStatelessSession();
        Foo foo = (Foo) session.get(Foo.class, fooId);
        session.close;
        return foo;
    }

    @Override
    public Foo update(Foo foo) {
        getHibernateTemplate().update(entity);
        return entity;
    }
}