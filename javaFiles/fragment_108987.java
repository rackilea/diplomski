@PersistenceContext
private EntityManager em;

public User update (User transientUser) {
    return em.merge(transientUser);
}