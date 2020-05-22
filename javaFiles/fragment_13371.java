try
    {
        conn = 
        (OracleConnection)oadbtransactionimpl.getJdbcConnection();
        String queryForEmpty = 
            "select ... query here"; 
        projectDetailsStatment = 
                conn.prepareStatement(queryForEmpty);
        projectDetailsStatment.setString(1,sprojectid);
        ResultSet rs = projectDetailsStatment.executeQuery();

    }
    catch(SQLException e)
   {
       String sqlErrMsg = e.getMessage();
       throw new OAException((new StringBuilder()).append("Exception in Finding Project Type:").append(sqlErrMsg).toString(), (byte)0);
   }
   finally
   {
      try{
      conn.close(); // throws exception here
      }
        catch(SQLException e)
      {
        //your code here
      }
   }