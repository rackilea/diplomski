Map<String, String> customAttributes = new HashMap<>();
customAttributes.put("age", "21");
customAttributes.put("gender", "Male");

AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
DynamoDB dynamodb = new DynamoDB(client);

Table table = dynamodb.getTable("users");
UpdateItemSpec updateItemSpec = new UpdateItemSpec()
          .withPrimaryKey("id", "91c2b60d-c428-403c-be42-8657b4f20669")
          .withUpdateExpression("set #customAttributes = :customAttributes")
          .withNameMap(new NameMap().with("#customAttributes", "customAttributes"))
          .withValueMap(new ValueMap().withMap(":customAttributes", customAttributes))
          .withReturnValues(ReturnValue.ALL_NEW);

UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
System.out.println(outcome.getItem().toJSONPretty());