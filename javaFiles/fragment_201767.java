Aggregation agg = newAggregation(
   match(Criteria.where("project").is(project)),
   project("employee", "manager"),         
   project().and("manager").concatArrays("employee").as("merged"),
   unwind("merged"),
   group("merged.userId").count().as("total"),
   project("total").and("userId").previousOperation(),
   sort(Sort.Direction.DESC, "total")
);