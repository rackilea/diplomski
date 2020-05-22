Connection con = DriverManager.getConnection
             ( "jdbc:myDriver:wombat", "myLogin","myPassword");

  Statement stmt = con.createStatement();
  ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM Table1");
  while (rs.next()) {
    int x = rs.getInt("a");
    String s = rs.getString("b");
    float f = rs.getFloat("c");
  }