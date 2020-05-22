public List<HistoricalData> getByUserIdAndLocation(List<Long> userIds) {
    Table table = dynamoDB.getTable(getTableName());
    ScanSpec scanSpec = new ScanSpec()
            .withFilterExpression("userId IN (" + buildInFilterExpression(userIds) + ")")
            .withValueMap(
                    buildValueMap(userIds)
            );
    ItemCollection<ScanOutcome> scanOutcome = table.scan(scanSpec);
    return convertItemToHistoricalData(scanOutcome.iterator());
}

private String buildInFilterExpression(List<Long> userIds) {
    StringBuilder builder = new StringBuilder();
    for (Long id : userIds) {
        builder.append(":user" + id + ",");
    }
    return builder.toString().substring(0, builder.length() - 1);
}

private ValueMap buildValueMap(List<Long> userIds) {
    ValueMap valueMap = new ValueMap();
    for (Long id : userIds) {
        valueMap.withNumber(":user" + id, id);
    }
    return valueMap;
}