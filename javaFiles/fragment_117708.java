DetachedCriteria subquery = DetachedCriteria.For(User.class)
    .createAlias("userLoginSession", "session")
    .add(Restrictions.eq("session.token", sessionToken))
    .setFirstResult(0)
    .setMaxResults(1)     // assuming token is unique otherwise this won't restrict users but loginsessions
    .setProjection(Projections.id());

Criteria crit = session.createCriteria(User.class)
    .add(Subqueries.propertyIn("id", subquery)
    .setFetchMode("userLoginSession", FetchMode.JOIN);