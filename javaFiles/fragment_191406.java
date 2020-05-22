Map<String, AttributeValue> attributeValues = new HashMap<>();
attributeValues.put(":id1", new AttributeValue().withN("100"));
attributeValues.put(":id2", new AttributeValue().withN("200"));

DynamoDBScanExpression dynamoDBScanExpression = new DynamoDBScanExpression()
                                                    .withFilterExpression("ID IN (:id1, :id2)")
                                                    .withExpressionAttributeValues(attributeValues);


PaginatedScanList<yourModelClass> scanList = dynamoDBMapper.scan(yourModelClass.class, dynamoDBScanExpression,
        new DynamoDBMapperConfig(DynamoDBMapperConfig.ConsistentReads.CONSISTENT));

Iterator<yourModelClass> iterator = scanList.iterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next().getTitle());
}