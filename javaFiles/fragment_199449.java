Condition scanFilterCondition = new Condition()
    .withComparisonOperator(ComparisonOperator.EQ.toString())
    .withAttributeValueList(new AttributeValue().withS("ready"));
Map<String, Condition> conditions = new HashMap<String, Condition>();
conditions.put("status", scanFilterCondition);

ScanRequest scanRequest = new ScanRequest()
    .withTableName("MasterProductTable")
    .withScanFilter(conditions);

ScanResult result = client.scan(scanRequest);