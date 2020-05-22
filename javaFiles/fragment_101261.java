DetachedCriteria subCriteria = DetachedCriteria.forClass(Queue.class, "sub")
    .add(Restrictions.eqProperty("sub.itemId","main.itemId"))
    .setProjection(Projections.projectionList().add(Projections.min("sub.queuedOn")));

session.createCriteria(Queue.class, "main")
   .add(Subqueries.propertyEq("main.queuedOn", subCriteria ));
   .add(Restrictions.eq("main.executed", false));
   .addOrder(Order.asc("main.queuedOn"))
   .list();