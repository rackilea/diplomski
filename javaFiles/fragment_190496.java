SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));;

AttributeValue mapped = new AttributeValue();
mapped = mapped.withS( dateFormatter.format( (Date) dateVal ) );

Map<String, AttributeValue> args = Collections.singletonMap(":v1", mapped);

DynamoDBScanExpression q = new DynamoDBScanExpression()
        .withIndexName('created_on-index')
        .withFilterExpression("created_on  <= :v1")
        .withExpressionAttributeValues(args);