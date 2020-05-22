class QueryTask implements Runnable {
    private final List queryList;
    public QueryTask(List queryList) {
        this.queryList = queryList;
    }

    @Override
    public void run() {
        try { //writing the updated data in DB
            aggregationDAO.updateCaseDetailsInOracle(queryList);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}