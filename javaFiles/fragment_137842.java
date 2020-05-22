DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(dynamoDB);
CreateTableRequest createTableRequest = dynamoDBMapper.generateCreateTableRequest(itemClass);
// Set your throughput here
createTableRequest.withProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

dynamoDB.createTable(createTableRequest);