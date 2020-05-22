AggregationOperation addFields = new AggregationOperation() {
    @Override
    public Document toDocument(AggregationOperationContext aggregationOperationContext) {
        Document document = new Document("comp", Document.parse("{'$gte':[{'$subtract':[{'$ifNull':['$acceptedDate', {'$date':" + System.currentTimeMillis() + "}]},'$lastVisit']},1296000000]}}"));      
        return new Document("$addFields", document);
    }
};

Aggregation aggregation = Aggregation.newAggregation(
        addFields,
        Aggregation.match(Criteria.where("comp").is(true))
        Aggregation.project().andExclude("comp");
);

List<Document> results = mongoTemplate.aggregate(aggregation, collection name, Document.class).getMappedResults();