Table table = dynamoDB.getTable(tableName);

Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
expressionAttributeValues.put(":x", "vl49uga5ljjcoln65rcaspmg8u");


QuerySpec spec = new QuerySpec()
    .withHashKey("HashKeyAttribute", "HashKeyAttributeValue")
    .withFilterExpression("data.byUserId = :x")
    .withValueMap(expressionAttributeValues);


ItemCollection<QueryOutcome> items = table.query(spec);

Iterator<Item> iterator = items.iterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next().toJSONPretty());
}