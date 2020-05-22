Criteria criteria = session.createCriteria(Customer.class);
criteria.createAlias("addressDetails", "addressDetails", JoinType.LEFT_OUTER_JOIN);

criteria.setProjection(Projections.projectionList()
        .add(Projections.property("userName").as("userName"))
        .add(Projections.property("addressDetails.countryCode")
        .as("addressDetails.countryCode")));

List<Customer> customers = criteria.setResultTransformer(
        new FluentHibernateResultTransformer(Customer.class)).list();