Integer result = session.doReturningWork(new ReturningWork<Integer> {
     @Override
     public Integer execute(Connection connection) throws SQLException {
         //...
         return call.getInt(1);        
     }
});