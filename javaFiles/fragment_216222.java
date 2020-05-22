private List<Activity> getbyIds(List<UUID> Ids) {
            List<Entity> activityEntityList = new ArrayList<Entity>();
            List<AttributeValue> attList = Ids.stream().map(x -> new AttributeValue(x.toString())).collect(Collectors.toList());

            DynamoDBScanExpression dynamoDBScanExpression = new DynamoDBScanExpression()
                    .withFilterConditionEntry("id", new Condition()
                            .withComparisonOperator(ComparisonOperator.IN)
                            .withAttributeValueList(attList));
            PaginatedScanList<Entity> list = dynamoDBMapper.scan(Entity.class, dynamoDBScanExpression);
}