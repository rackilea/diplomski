DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
Map<String, ExpectedAttributeValue> expectedAttributes = 
    ImmutableMap.<String, ExpectedAttributeValue>builder()
        .put("hashKey", new ExpectedAttributeValue(false))
        .put("rangeKey", new ExpectedAttributeValue(false))
        .build();
saveExpression.setExpected(expectedAttributes);
saveExpression.setConditionalOperator(ConditionalOperator.AND);
try {
    dynamoDBMapper.save(objectToSave, saveExpression);
} catch (ConditionalCheckFailedException e) {
    //Handle conditional check
}