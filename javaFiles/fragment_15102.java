final Criteria query = sessionFactory.getCurrentSession().createCriteria(Client.class);
query.createAlias("clientPlan", "clientPlanAlias");
query.createAlias("clientOldPlan", "clientOldPlanAlias");
...

query.add(Restrictions.eqProperty("clientPlanAlias.category", "clientOldPlanAlias.category");