String query ="SELECT Username FROM data INNER JOIN Permissions "
        + "ON data.Role = Permissions.Permission "
        + "WHERE Username = ? AND Function = ? "
        + "LIMIT 1"; // One record only
  try (PreparedStatement stm = con.prepareStatement(query)) {
      stm.setString(1, user);
      stm.setString(2, methodName);
      try (ResultSet res = stm.executeQuery()) {
          if (res.next()) {           
              System.out.println("Welcome " + user);
              return true;
          }
          return false;
      }
  }