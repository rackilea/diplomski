session.beginTransaction();
ResultObject result = session.doReturningWork(new ReturningWork<ResultObject>() {

    @Override
    public ResultObject execute(Connection conn) throws SQLException {
        // execute your SQL
        // create and return result object
    });
}
session.getTransaction().commit();

// work with ResultObject