public static final AmazonDynamoDBClient DYNAMODB_CLIENT = new AmazonDynamoDBClient(CREDENTIALS_PROVIDER);
public static final DynamoDB DYNAMODB = new DynamoDB(DYNAMODB_CLIENT);

...

Table table = DYNAMODB.createTable(request);
table.waitForActive();