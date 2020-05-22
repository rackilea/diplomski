class SQLQueryCallable implements Callable<SQLResultSet> {
    private String query;
    public SQLQueryCallable(String query) {
        this.query = query;
    }
    public SQLResultSet Call() throws Exception {
        // execute query
        return results;
    }
}
ExecutorService ex = Executors.newSingleThreadExecutor();

// in DBAdmin somewhere:
    public SQLResultSet runQuery(String query) {
        Future<SQLResultSet> f = ex.submit(new SQLQueryCallable(query));
        return f.get(); // this waits for the query to complete
    }