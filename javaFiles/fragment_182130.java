try {
  connection con.setAutoCommit(false);        
  PreparedStatement prepStmt = con.prepareStatement(    
    "insert into product(code,name,price,available) values (?,?,?,?");
  Iterator<Product> it = li.iterator();
  while(it.hasNext()){
     Product p = it.next();
    prepStmt.setString(1,p.getCode());            
    prepStmt.setString(2,p.getCode());
    prepStmt.setInt(3,p.getPrice());
    prepStmt.setBoolean(4,p.isAvailable());
    prepStmt.addBatch();                      

  }      
  int [] numUpdates=prepStmt.executeBatch();
  for (int i=0; i < numUpdates.length; i++) {
    if (numUpdates[i] == -2)
      System.out.println("Execution " + i + 
        ": unknown number of rows updated");
    else
      System.out.println("Execution " + i + 
        "successful: " + numUpdates[i] + " rows updated");
  }
  con.commit();
} catch(BatchUpdateException b) {
  // process BatchUpdateException
}