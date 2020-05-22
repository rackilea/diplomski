Criteria c = session.createCriteria(User.class, "user");

DetachedCriteria roleOfUserWithName = DetachedCriteria.forClass(Role.class, "role");
roleOfUserWithName.createAlias("role.users", "userOfTheRole");
roleOfUserWithName.add(Restrictions.eqProperty("userOfTheRole.id", "user.id"));
roleOfUserWithName.add(Restrictions.eq("role.name", roleName);
roleOfUserWithName.setProjection(Projections.id());

c.add(Subqueries.notExists(roleOfUserWithName));