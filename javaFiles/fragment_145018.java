final Criteria innerCriteria = getSession().createCriteria(YourEntity.class);
// SOME CONDITIONS
innerCriteria.add(Restrictions.eq("someColumn", "someValue"));
innerCriteria.addOrder(Order.desc("timestamp"));
innerCriteria.setMaxResults(15);
innerCriteria.setProjection(Projections.id());
List<YourIdClass> ids = innerCriteria.list();


final Criteria criteria = getSession().createCriteria(YourEntity.class);
criteria.add(Restrictions.not(Restrictions.in("id", ids)));
List<YourEntity> results = criteria.list();