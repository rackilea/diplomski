Criteria criteria=session.createCriteria(AssignCoScholastic.class,"assignCoScholastic");
    criteria.createAlias("assignCoScholastic.coscholastic", "coscholasticss")
    .setProjection(Projections.distinct(Projections.projectionList()
    .add(Projections.property("coscholasticss.coScholasticId"))
    .add(Projections.property("coscholasticss.coscholasticName"))));
    criteria.add(Restrictions.eq("assignClass.assignID", assiginedClass));
    criteria.add(Restrictions.eq("schoolModel.school_id", schoolId));
    criteria.add(Restrictions.like("year", year));