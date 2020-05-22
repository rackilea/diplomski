Criteria criteria = Criteria.where("onlinedate").lte(date).orOperator(
    Criteria.where("offlinedate").gte(date),
    Criteria.where("offlinedate").is(null)
);

Query query = new Query().addCriteria(criteria);

System.out.println(query.getQueryObject());