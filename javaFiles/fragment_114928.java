try {
...
  connection con.setAutoCommit(false);                   
  PreparedStatement prepStmt = con.prepareStatement(    
    "UPDATE DEPT SET MGRNO=? WHERE DEPTNO=?");           
  prepStmt.setString(1,mgrnum1);                         
  prepStmt.setString(2,deptnum1);
  prepStmt.addBatch();                                   

  prepStmt.setString(1,mgrnum2);                        
  prepStmt.setString(2,deptnum2);
  prepStmt.addBatch();
  int [] numUpdates=prepStmt.executeBatch();             
  for (int i=0; i < numUpdates.length; i++) {            
    if (numUpdates[i] == -2)
      System.out.println("Execution " + i + 
        ": unknown number of rows updated");
    else
      System.out.println("Execution " + i + 
        "successful: " numUpdates[i] + " rows updated");
  }
  con.commit();                                          
} catch(BatchUpdateException b) {
  // process BatchUpdateException
}