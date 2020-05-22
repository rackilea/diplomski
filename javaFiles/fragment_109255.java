List<Row> rows = ... // all the row objects.
Multimap<String, Row> rowsMap = Multimaps.index(rows, new Function<Row, String>() {
    @Override
    public String apply(Row row) {
        return row.getRowKey(); // assume that getRowKey() return the key of one row.
    }
});