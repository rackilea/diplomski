Criteria criteria = currentSession().createCriteria(Referral.class, "r");
criteria.createAlias("r.course", "course");

ProjectionList projections = Projections.projectionList();
projections.add(Projections.groupProperty("course.id"));
projections.add(Projections.count("r.id"));

return list(criteria
        .setProjection(projections));