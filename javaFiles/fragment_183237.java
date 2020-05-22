DynamoDBScanExpression queryExpression = new DynamoDBScanExpression();

      Map<String, AttributeValue> valueMap = new HashMap<>();

     valueMap.put(":year", new AttributeValue().withS(2016));

    queryExpression.withFilterExpression("#y = :year).

   .withExpressionAttributeValues(valueMap);

   Map<String, String> expression = new HashMap<>();

            expression.put("#y", "year");

     queryExpression.withExpressionAttributeNames(expression);