String connectionString = String.format("DefaultEndpointsProtocol=http;AccountName=%s;AccountKey=%s", ACCOUNT_NAME, ACCOUNT_KEY);
CloudStorageAccount account = CloudStorageAccount.parse(connectionString);
CloudAnalyticsClient client = account.createCloudAnalyticsClient();
CloudTable metrics = client.getMinuteMetricsTable(StorageService.BLOB);
System.out.println(metrics.getName());
String queryString = TableQuery.combineFilters(
                TableQuery.generateFilterCondition("PartitionKey", QueryComparisons.GREATER_THAN_OR_EQUAL, "20170602T1400"),
                Operators.AND,
                TableQuery.generateFilterCondition("PartitionKey", QueryComparisons.LESS_THAN_OR_EQUAL, "20170602T1420"));
TableQuery<TableServiceEntity> query = TableQuery.from(TableServiceEntity.class).where(queryString);
for(TableServiceEntity entity : metrics.execute(query)) {
    System.out.println(entity.getPartitionKey()+"\t"+entity.getRowKey());
}