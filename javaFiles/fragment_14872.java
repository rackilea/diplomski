try(PreparedStatment ps = con.prepareStatement("SELECT * " +
         " FROM Contact WHERE contactName like ?")) {
    ps.setString(1, "%name1%");
    try(ResultSet rs = ps.executeQuery()) {
      while(rs.next()) {
        //process your data
      }
    }
  } catch(Exception e) {
    //deal with it
  }