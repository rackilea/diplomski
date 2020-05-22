Aggregation agg = Aggregation.newAggregation(
   unwind("workLogs"),
   match(Criteria
      .where("workLogs.month").is(1)
      .and("workLogs.year").is(2017)
   ),
   group("_id").push("workLogs").as("workLogs"),
   project("workLogs").andExclude("_id")
 );