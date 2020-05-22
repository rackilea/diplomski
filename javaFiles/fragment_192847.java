Criteria crit = getSession().createCriteria(TestTable.class, "t");
ProjectionList projectionList = Projections.projectionList();
projectionList.add(Projections.property("id"));
projectionList.add(Projections.property("param1"));
projectionList.add(Projections.property("param2"));
projectionList.add(Projections.property("param1"));
crit.setProjection(projectionList);
List results = crit.list();