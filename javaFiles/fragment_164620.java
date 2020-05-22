Session session = sessionFactory.openSession();
Transaction tx = session.beginTransaction();
//get Connction from Session
session.doWork(new Work() {
       @Override
       public void execute(Connection conn) throws SQLException {
          PreparedStatement pstmt = null;
          try{
           String sqlInsert = "insert into sampletbl (name) values (?) ";
           pstmt = conn.prepareStatement(sqlInsert );
           int i=0;
           for(String name : list){
               pstmt .setString(1, name);
               pstmt .addBatch();

               //20 : JDBC batch size
             if ( i % 20 == 0 ) { 
                pstmt .executeBatch();
              }
              i++;
           }
           pstmt .executeBatch();
         }
         finally{
           pstmt .close();
         }                                
     }
});
tx.commit();
session.close();