Criteria productCriteria = session.createCriteria(Product.class);
Criteria connectionCriteria  = criteria.createCriteria("connections", "c", CriteriaSpecification.INNER_JOIN);

ProjectionList columns = Projections.projectionList();

columns.add(Projections.property("productId"));
columns.add(Projections.property("name"));
columns.add(Projections.property(connectionCriteria.getAlias() + ".connectionId"));
columns.add(Projections.property(connectionCriteria.getAlias() + ".name"));

productCriteria.setProjection(columns);

List<Product> prodList = productCriteria.list();