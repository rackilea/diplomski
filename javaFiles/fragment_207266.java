// Create the criteria assuming session is open
Criteria criteria = session.createCriteria(X.class, "x");

// Give the Y association an alias
criteria.createAlias("x.yCollectionName", "yCollectionAlias"); 

// Get the count of IDs in the joined collection
criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("yCollectionAlias.id"))
.add(Projections.count("yCollectionAlias.id").as("yCollectionAliasCount")));

// Sort the criteria associated by Ys
criteria.addOrder(Order.desc("yCollectionAliasCount"));