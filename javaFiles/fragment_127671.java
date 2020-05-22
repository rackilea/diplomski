UnwindOperation unwind = Aggregation.unwind("usage_history");

  BasicDBObject object = new BasicDBObject("_id", "$_id");

  for (String string : fields) {

   object.append(string, new BasicDBObject("$first", "$" + string));
  }

  object.append("total", new BasicDBObject("$sum", new BasicDBObject("$cond",
    new Object[] { new BasicDBObject("$gte", new Object[] { "$usage_history.date", calendarMin.getTime() }),
      "$usage_history.total_usage", 0 })));

  BasicDBObject groupObject = new BasicDBObject("$group", object);
  DBObject groupOperation = (DBObject) groupObject;

  MatchOperation matchMain = Aggregation
    .match(new Criteria().andOperator(criteriaList.toArray(new Criteria[criteriaList.size()])));

  Aggregation aggregation = Aggregation.newAggregation(unwind, new CustomGroupOperation(groupOperation),
    matchMain);