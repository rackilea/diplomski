private QueryRunner runner = new QueryRunner();   //creating global runner object which used across all methods in my class

public boolean saveCar(Car car){
   Connection con = null;
   try{
        con = ....//get connection
        con.setAutoCommit(false);

        storeCar(car, con);
        storeWheels(car, con);
        storeEngine(car, con);

        DbUtils.commitAndCloseQuietly(con);
   } catch(Exception e){
       DbUtils.rollbackAndCloseQuietly(con);
   } 

}


private void storeWheels(Car car, Connection con) throws Exception{
    String sql = "...";
    runner.update(connection, sql);  //all functionality encapsulated, performing update, closing statement, etc..
}