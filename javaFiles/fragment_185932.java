conn.setAutoCommit(false);
PreparedStatement stmt = conn.prepareStatement(
        "INSERT INTO my_table (col_a, col_b, ...)"
        + " VALUES (?, ?, ...)");
int batchSize = 1000;
int rows = 0;
for (Map<String, String> values : mainMap.values()) {
    int i = 0;
    stmt.setString(++i, values.get("col_a"));
    stmt.setString(++i, values.get("col_b"));
    // ...
    stmt.addBatch(); // add the row to the batch
    if (++rows % batchSize == 0) {
        // batch-sizing: execute...
        stmt.executeBatch();
    }
}

if (rows % batchSize != 0) {
    // a last execution if necessary...
    stmt.executeBatch();
}
conn.commit(); // atomic action - if any record fails, the whole import will fail