String query ="SELECT EXISTS(SELECT * FROM data INNER JOIN Permissions "
        + "ON data.Role = Permissions.Permission "
        + "WHERE Username = ? AND Function = ?)";
  try (PreparedStatement stm = con.prepareStatement(query)) {
      stm.setString(1, user);
      stm.setString(2, methodName);
      try (ResultSet res = stm.executeQuery()) {
          if (res.next()) {           
              boolean exists = res.getBoolean(1);
              if (exists) {
                  System.out.println("Welcome " + user);
              }
              return exists;
          }
          return false;
      }
  }