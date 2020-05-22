DetachedCriteria excludedGroups = DetachedCriteria.forClass(Group.class);
excludedGroups.createAlias("userCollection", "u");
excludedGroups.add(Restrictions.isNotNull("u.birthDate"));
excludedGroups.setProjection(Projections.id());

Criteria c = session.createCriteria(Group.class);
c.add(Subqueries.propertyNotIn("id", excludedGroups));