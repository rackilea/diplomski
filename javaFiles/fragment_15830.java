JDBCTemplate jdbcTemplate =  new JdbcTemplate(dataSource); 
boolean successfullyExecuted = false;
int failCount = 0;
while (!successfullyExecuted){
 try{
    jdbcTemplate.execute(new CallableStatementCreator() {
        @Override
        public CallableStatement createCallableStatement(Connection con)
        throws SQLException {
            return con.prepareCall(query);
        }
    }, new CallableStatementCallback() {
        @Override
        public Object doInCallableStatement(CallableStatement cs)
        throws SQLException {
            cs.setString(1, subscriberID);
            cs.execute();
            return null;
        }
    });
    successfullyExecuted = true;
 } catch (DataAccessException dae) {
     if (failedCount < 5){
        failedCount ++;
        try{java.lang.Thread.sleep(2 * 1000L); // Wait for 2 seconds
        }catch(java.lang.Exception e){}
     }else{
     throw new CougarFrameworkException(
             "Problem removing subscriber from events queue: "
             + subscriberID, dae);
     }
 } catch (java.sql.SQLException sqle){
     if (failedCount < 5){
        failedCount ++;
     }else{
     try{java.lang.Thread.sleep(2 * 1000L); // Wait for 2 seconds
     }catch(java.lang.Exception e){}
     throw new CougarFrameworkException(
             "Problem removing subscriber from events queue: "
             + subscriberID, dae);
     }
 }
}