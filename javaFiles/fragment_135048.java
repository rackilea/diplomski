return sessionFactory.getCurrentSession()
    .createCriteria(PersonProgramActivity.class, "ppa")
    .setProjection(Projections.projectionList()
        .add(Projections.alias(Projections.sum("numberOfPoints"), "ppa.numberOfPoints"))
        .add(Projections.groupProperty("person.id")))
    .setFirstResult(start)
    .setFetchSize(size)
    .addOrder(Order.desc("ppa.numberOfPoints"))
    .list();