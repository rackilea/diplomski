while(rs.next()){
  if (rs.rowUpdated){
      String strOrigVal = "";
      ResultSet ors = rs.getOriginalRow(); //you should catch the return value
      if(ors.next()){ //move to the first cursor
        strOrigVal = ors.getString("col1");
      }    
  }
}