CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
CriteriaQuery<DataStatus> criteriaQuery = criteriaBuilder.createQuery(DataStatus.class);
Root<DataStatus> root = criteriaQuery.from(DataStatus.class);

Subquery<Date> subquery = criteriaQuery.subquery(Date.class);
Root<DataStatus> innerRoot = subquery.from(DataStatus.class);

subquery.select(innerRoot.get("startTime"))
        .where(criteriaBuilder.and(criteriaBuilder.equal(innerRoot.get("name"), "Alice"),
                criteriaBuilder.equal(innerRoot.get("server"), root.get("server"))));

criteriaQuery.select(root).where(
        criteriaBuilder.and( criteriaBuilder.isNotNull( root.get( "server" ) ),
                criteriaBuilder.equal(root.get("name"), "Bob" ),
                criteriaBuilder.lessThan(root.<Date> get("startTime"), subquery)

        ) );

Query<DataStatus> query = session.createQuery(criteriaQuery);
List<DataStatus> resultList = query.getResultList();