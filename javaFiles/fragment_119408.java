Document filter = new Document("senses.lang", "EN").append("senses.source", "EN_DICTIONARY");

DBObject filterExpression = new BasicDBObject();
filterExpression.put("input", "$senses");
filterExpression.put("as", "sense");
filterExpression.put("cond", new BasicDBObject("$and", Arrays.<Object>asList(
        new BasicDBObject("$eq", Arrays.<Object>asList("$$sense.lang", "EN")),
        new BasicDBObject("$eq", Arrays.<Object>asList("$$sense.source", "EN_DICTIONARY")))
));

BasicDBObject projectionFilter = new BasicDBObject("$filter", filterExpression);

AggregateIterable<Document> documents = collection.aggregate(Arrays.asList(
        new Document("$match", filter),
        new Document("$project", new Document("senses", projectionFilter))));

for (Document document : documents) {
    logger.info("{}", document.toJson());
}