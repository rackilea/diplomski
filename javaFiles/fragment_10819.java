Criteria criteria = session.createCriteria(Link.class);
criteria.createAlias("container", "containerAlias");
criteria.add(Restrictions.isNotNull("containerAlias.id"));
criteria.setProjection(Projections.projectionList()
    .add(Projections.id())
    .add(Projections.property("containerAlias.id")));