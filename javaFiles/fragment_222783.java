class BatchPreparedStatementHolder {

    private int batchCount;
    private PreparedStatement ps;

    public BatchPreparedStatementHolder(PreparedStatement statement){
        batchCount = 0;
        ps = statment;
    }

    public void addBatch(){
        ps.addBatch();
        // increment how many times a batch has been added to the statement.
        // execute batch if necessary.
        if (++batchCount> 5000) {
            ps.executeBatch();
            batchCount = 0;
        }
    }

    ....

}