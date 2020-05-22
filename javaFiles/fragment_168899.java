List<Pickup> pickupList = null;

    DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(dynamoDBClient);

    Pickup pickup = new Pickup();
    pickup.setCorrelationId(correlationId);

    Map<String, AttributeValue> attributeValues = new HashMap<>();
    attributeValues.put(":partnerId", new AttributeValue(partnerId));

    DynamoDBQueryExpression<Pickup> queryExpression = new DynamoDBQueryExpression<Pickup>().withHashKeyValues(pickup)               
            .withFilterExpression("partnerId = :partnerId")
            .withExpressionAttributeValues(attributeValues);

    pickupList = dynamoDBMapper.query(Pickup.class, queryExpression);

    pickupList.stream().forEach(i -> System.out.println(i.toString()));