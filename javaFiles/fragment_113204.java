DetachedCriteria subquery = DetachedCriteria.forClass(B.class)
.setProjection( Property.forName("a.ID") )
.add(Restrictions.isNotNull("a.ID"));

session.createCriteria(A.class)
.add ( Property.forName("ID").notIn(subquery) )
.list();