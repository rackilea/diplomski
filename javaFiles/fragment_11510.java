Criteria c = session.createCriteria(DiscountFares.class, "df");
c.createAlias("df.aircompanyId", "ac", JoinType.LEFT_OUTER_JOIN);
c.setProjection(Projections.projectionList()
    .add(Projections.property("df.id"))
    .add(Projections.property("df.discount"))
    .add(Projections.property("df.fareCode"))
    .add(Projections.property("ac.id")));