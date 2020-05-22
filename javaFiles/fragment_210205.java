DetachedCriteria subquery = DetachedCriteria.forClass(ActivityLogParameter.class, "alp")
        .createAlias("activityLog", "al",JoinFragment.LEFT_OUTER_JOIN)
        .setProjection(Projections.projectionList()
                .add(Projections.count("id"), "alpId"));

subquery = subquery.add( Property.forName("al.id").eqProperty("mainAl.id") );

subquery = subquery.add(Restrictions.or(Restrictions.eq("alp.value", UValue), Restrictions.ne("alp.key", "L")));
subquery = subquery.add(Restrictions.or(Restrictions.eq("alp.value", LValue), Restrictions.ne("alp.key", "U")));

Criteria criteria = getCurrentSession().createCriteria(type, "mainAl");

criteria = criteria.add(Subqueries.eq(new Long(2), subquery));