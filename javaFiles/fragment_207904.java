/**
 * Select a single row from any ORM type. Returns a single result in a list
 * or an empty list. Avoids NoResultException() from JPA's getSingleResult()
 * method
 * 
 * @param key
 *            The unique primary key to select.
 * @param ormClass
 *            The ORM class to select.
 * @param singularAttribute
 *            A JPA SingularAttribute<<ormType>, <primaryKey> data
 *            type> containing the mapping to the primary key.
 * @return list The selected ORM type in a list. If no result the list is
 *         empty.
 */
public static <T, X> List<T> selectOneRow(int key, Class<T> ormClass,
        SingularAttribute<T, X> singularAttribute) {
    Session session = HibernateSessionFactory.getFactory().openSession();
    List<T> list = null;
    Transaction tx = null;

    try {
        tx = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(ormClass);
        Root<T> root = criteria.from(ormClass);
        criteria.select(root);
        criteria.where(builder.equal(root.get(singularAttribute), key));

        list = session.createQuery(criteria).getResultList();

        tx.commit();
    } catch (HibernateException e) {
        if (tx != null)
            tx.rollback();
        log.error(e);
    } finally {
        session.close();
    }
    return list;
}