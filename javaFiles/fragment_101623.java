Criteria criteria = new Criteria().norOperator(
   Criteria.where("onlinedate").gte(date)
   .and("offlinedate").lte(date)
);

Query query = new Query().addCriteria(criteria);

System.out.println(query.getQueryObject());