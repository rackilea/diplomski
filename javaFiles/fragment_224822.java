AggregationOperation match = Aggregation.match(Criteria.where("_id").is(1));
 AggregationOperation unwind = Aggregation.unwind("connections");
 AggregationOperation match2 = Aggregation.match(Criteria.where("connections.name").regex(".*Han.*"));
 AggregationOperation sort = Aggregation.sort(Sort.Direction.ASC, "connections.steps");
 AggregationOperation group = Aggregation.group("_id").push("connections").as("connections").first("name").as("name");
 AggregationOperation project2 = Aggregation.project("connections").andExclude("_id").andInclude(Fields.from(Fields.field("name", "id")));