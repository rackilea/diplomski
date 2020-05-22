DistinctIterable<String> distinctIds =
    mongoTemplate.getCollection(mongoTemplate.getCollectionName(Employee.class))
    .distinct("id", String.class);

return Lists.newArrayList(distinctIds);

// or

BasicDBObject dbObject = new BasicDBObject();
dbObject.append("name", new BasicDBObject("$regex", ".*and.*"));

DistinctIterable<String> distinctIds =
    mongoTemplate.getCollection(mongoTemplate.getCollectionName(Employee.class))
    .distinct("id", dbObject, String.class);

return Lists.newArrayList(distinctIds);