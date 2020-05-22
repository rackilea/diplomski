//your query
  sql=Select * from t
  Statement  stmt = yourDBConnection.createStatement();
  ResultSet rs = stmt.executeQuery(sql);
  if (!rs .isBeforeFirst() ) {    
   System.out.println("Table is empty"); 
  }