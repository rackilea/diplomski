public int[] executeBatchUpdate(List<String> sqlStatements) throws EasyORMException{


    int[] batchResults=null;

    Statement stmt=null; 

    for (int i=0; i<sqlStatements.size();i++){

    try{

   if(stmt==null)    
     stmt = conn.createStatement();

    stmt.addBatch(sqlStatements.get(i));

    }catch(SQLException sqle){     
      //log or throw exception  
    }    
    }//end for loop 

    try {

     batchResults = stmt.executeBatch();

    }catch (SQLException sqle) {

      //log or throw exception

     }    

}

   return batchResults;

}