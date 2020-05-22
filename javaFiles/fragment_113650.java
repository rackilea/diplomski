public List<T> queryBy(String field, Object val) {
    Session session = sessionFactory.getCurrentSession();
    Criteria criteria = session.createCriteria(persistentClass);
    criteria.add(Restrictions.eq(field, val));
    @SuppressWarnings("unchecked")
    List<T> l = criteria.list();
    return l;
}