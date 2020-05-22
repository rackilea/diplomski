String sql = "INSERT INTO `kanat`(Number1) VALUES ( ? )";
  PreparedStatement ps = null;

  try {

     ps = con.prepareStatement(sql);

     while( ... ) {
        String numberOfLine = ...

        ps.setString(1, numberOfLine);
        ps.executeUpdate();

     }
  } catch (SQLException e ) {
      e.printStackTrace();
  } finally {
      if (ps != null) {
          ps.close();
      }
  }