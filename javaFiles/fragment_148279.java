public List<A> get(String var) {
    Session session = this.getHibernateTemplate().getSessionFactory()
            .openSession();
    Criteria criteria = session.createCriteria(A.class);
    criteria.add(Restrictions.eq("name", var));
    return criteria.list();
}


List<A> list2 = get (var);