private ExecutionResult runCypher(String query, Map params) {
    try (Transaction tx = service.beginTx()) {
        ExecutionResult result = engine.execute(query, params);
        // extract the data out of the result, you cannot iterate over it outside of a tx
        Collection resultData = ....
        tx.success();
        return resultData;
    }
}