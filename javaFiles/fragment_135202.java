public List getCarters(final int firstResult, final int maxResults) {

    final Criteria criteria = sessionFactory.getCurrentSession()
                      .createCriteria(SomePersistentClass.class);
                      .add(Restrictions.eq("name", "Carter"))
    criteria.setFirstResult(firstResult);
    criteria.setMaxResults(maxResults);

    return criteria.list();
}