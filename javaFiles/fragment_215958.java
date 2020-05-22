@Override
public void execute(final Database arg0) throws CustomChangeException {
    JdbcConnection dbConn = (JdbcConnection) arg0.getConnection();
    try {
         ... do funny stuff ...
    } catch (Exception e) {
        // swallow the exception !
    }
}