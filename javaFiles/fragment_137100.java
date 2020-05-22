int count = 0;
int batch = 100; //Send 100 requests at a time
BulkOperations bulkOps = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, YourPojo.class);
List<DateRange> dateRanges = generateDateRanges(from, to, step); //Add a function to generate date ranges with the defined step.

for (DateRange dateRange: dateRanges){
    Query query = new Query();
    Criteria criteria = new Criteria().andOperator(Criteria.where("timestamp").gte(dateRange.from), Criteria.where("timestamp").lte(dateRange.to));
    query.addCriteria(criteria);
    bulkOps.remove(query);
    count++;
    if (count == batch) {
        bulkOps.execute();
        count = 0;
    }
}

if (count > 0) {
    bulkOps.execute();
}