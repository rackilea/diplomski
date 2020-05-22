public CommonHibernateDao<T extends Commercial> implements Dao<T> 
{
    private final Class<T> entityType;

    protected CommonHibernateDao(Class<T> entityType) {
        this.entityType = entityType;
    }

    public List<T> getAll() {
        // hibernate get all implementation
    }
}