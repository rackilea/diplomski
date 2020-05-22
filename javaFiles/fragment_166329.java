DetachedCriteria subquery = DetachedCriteria.forClass(AETable.class, "b")
 .add(Property.forName("b.classpk").eqProperty("a.classpk"))
 .add(Property.forName("b.userid").eqProperty("a.userid"))
 .add(Property.forName("b.modifiedDate").gtProperty("a.modifiedDate"));

Criteria criteria = session.createCriteria(AETable.class, "a")
 .add(Property.forName("userid").eq(new Integer(10146)))
 .add(Subqueries.notExists(subquery);