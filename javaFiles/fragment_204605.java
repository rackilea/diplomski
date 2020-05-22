final List<Optional<SimpleWorkDataValue>> columnKeyList =
        ImmutableList.copyOf(table.columnKeySet());
    for (final SimpleWorkDataValue timeSeriesValue : timeSeriesValues) {
        final Optional<SimpleWorkDataValue> rowKey = Optional.of(timeSeriesValue);
        for (final Optional<SimpleWorkDataValue> columnKey : columnKeyList) {
            if (!table.contains(rowKey, columnKey)) {
                table.put(rowKey, columnKey, ResultSet.EMPTY);
            }
        }
    }