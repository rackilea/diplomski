Aggregation agg = newAggregation(
   match(Criteria.where("project").is(project)),
   unwind("recruiters"),
   group("recruiters.fullName").count().as("total"),
   project("total").and("fullName").previousOperation(),
   sort(Sort.Direction.DESC, "total")
);