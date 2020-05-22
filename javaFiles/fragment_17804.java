Aggregation agg = newAggregation(
    project("id")
        .andExpression("month(createdDate)").as("month_joined")
        .andExpression("year(createdDate)").as("year"),
    match(Criteria.where("year").is(2016)),
    group("month_joined").count().as("number"),
    project("number").and("month_joined").previousOperation(),
    sort(ASC, "number")
);

AggregationResults<JoinCount> results = mongoTemplate.aggregate(agg, 
                                                     "collectionName", JoinCount.class);
List<JoinCount> joinCount = results.getMappedResults();