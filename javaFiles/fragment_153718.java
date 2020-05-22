@Override
public List<Conditionnement> find(ConditionnementCriteria conditionnementCriteria) {
    Criteria criteria = getHibernateSession().createCriteria(Conditionnement.class, "c");
    criteria.createCriteria("c.langue", "l", JoinType.LEFT_OUTER_JOIN);
    return criteria.list();
}