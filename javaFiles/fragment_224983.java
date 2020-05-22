boolean isResultSet = statement.execute(sql);
while (true) {
    if (isResultSet) {
        try (ResultSet rs = statement.getResultSet()) {
            // do something with result set
        }
    } else {
        int updateCount = statement.getUpdateCount();
        if (updateCount == -1) {
            // -1 signals no more results
            break;
        }
        // do something with update count
    }
    // move to next result
    isResultSet = statement.getMoreResults();
}