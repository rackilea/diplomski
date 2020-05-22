CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Table1> criteriaQuery = criteriaBuilder.createQuery(Table1.class);
    Root<Table1> table1 = criteriaQuery.from(Table1.class);

    Expression<Byte> expression = table1.get("tmstmp"); // ...NOTE: column name is "tmstmp"...
    Expression<Timestamp> castFunction = criteriaBuilder.function("TIMESTAMP", Timestamp.class, expression);
    Predicate predicate = criteriaBuilder.greaterThanOrEqualTo(castFunction, tmstmp);

    //NOTE: should be able to add to predicate...
    //      e.g.,   
    //          predicate = criteriaBuilder.and(predicate, otherPredicate);

    criteriaQuery.where(predicate);
    TypedQuery<Table1> query = entityManager.createQuery(criteriaQuery);
    List<Table1> resultList = query.getResultList();