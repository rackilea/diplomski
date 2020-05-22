String sql = "SELECT * FROM test";
  ResultSet rs = stmt.executeQuery(sql);

  if(rs.next()){
      do {

        if (rs.getString("sent").equals("0")) {

          try{
             //if there is a row and it is equals to 0.. so update it to 1.. 

             String sql2 = "UPDATE test SET test='1' WHERE test=....";
             Statement updateStatement = <create statement here>;

             int rs3 = updateStatement.executeUpdate();
             updateStatement.close();
          }catch (SQLException sqlex) { 
             sqlex.printStackTrace();
          }
        }
     }while(rs.next());
   }else {
      try{
             //insert if i couldn't get any rows in the table
             String sql2 = "INSERT INTO test......";
             Statement insertStatement = <create statement here>;
             int rs3 = insertStatement.executeUpdate();
             insertStatement.close();
          }catch (SQLException sqlex) {
             sqlex.printStackTrace();
          }
    }

    rs.close();
    stmt.close();
    conn.close();