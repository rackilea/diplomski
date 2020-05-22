public abstract class AbstractHibernateDao<T extends Object>
    implements AbstractDao<T> {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(T t) { getSession().save(t); }

    public void update(T t) { getSession().update(t); }

    ...
}