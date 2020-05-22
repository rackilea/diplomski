DBObject projectFields = new BasicDBObject("_id", 0);
projectFields.put("customer_count", new BasicDBObject( "$size", "$customers" ));
DBObject project = new BasicDBObject("$project", projectFields);

AggregationOutput output = db.getCollection("collectionName").aggregate(project);

System.out.println("\n" + output);