try{
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@" + 
         ipAddress + ":1521:" + dbname,userName,password); 
       Statement  stmt = con.createStatement();
       String query = "select * from table_name";
       ResultSet rs = stmt.executeQuery(query);
       while (rs.next()) { 
        System.out.println(rs.getString(1));
    }

  } catch (SQLException e ) {

  } finally {
    if (stmt != null) { stmt.close(); }
  }