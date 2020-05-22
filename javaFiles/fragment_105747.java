@Repository
public abstract class DaoHibernate<T> implements Dao<T> {

    @Override
    public T reattach(T entity) {
        if (getCurrentSession().contains(entity)) {
            return entity;
        }
        if (entity instanceof User) {
            return (T) reattachedUser((User) entity);
        }
        if (entity instanceof Content) {
            Content content = (Content) entity;
            User user = content.getUser();
            if (!currentSession().contains(user)) {
                content.setUser(reattachedUser(user));
            }
            content.setAttributes(persistentAttributesMap(content.getId(), content.getAttributes(), Content.class);
            getCurrentSession().lock(content, LockMode.NONE);
            return entity;
        }
        throw new UnsupportedOperationException("reattach is not supported for entity: " + entity.getClass().getName());
    }

    private User reattachedUser(User user) {
        user.setAttributes(persistentAttributesMap(user.getId(), user.getAttributes(), User.class));
        getCurrentSession().lock(user, LockMode.NONE);
        return user;
    }

    @SuppressWarnings ("unchecked")
    private Map<String, String> persistentAttributesMap(long id, Map<String, String> attributes, Class clazz) {
        SessionFactory sessionFactory = getSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();
        String role = clazz.getName() + ".attributes";
        CollectionPersister collectionPersister = ((SessionFactoryImplementor) sessionFactory).getCollectionPersister(role);
        MapType mapType = (MapType) collectionPersister.getCollectionType();
        PersistentMap persistentMap = (PersistentMap) mapType.wrap((SessionImplementor) currentSession, attributes);
        persistentMap.setOwner(id);
        persistentMap.setSnapshot(id, role, ImmutableMap.copyOf(attributes));
        persistentMap.setCurrentSession(null);
        return persistentMap;
    }

    ...
}