String selectSQL = "SELECT USER_ID, USERNAME FROM DBUSER WHERE USER_ID = ?";

dbConnection = getDBConnection();
preparedStatement = dbConnection.prepareStatement(selectSQL);
preparedStatement.setInt(1, 1001);

// execute select SQL stetement
ResultSet rs = preparedStatement.executeQuery();

try {
  while (rs.next()) {
    String userid = rs.getString("USER_ID");
    String username = rs.getString("USERNAME");
    System.out.println("userid : " + userid);
  }

  } catch (SQLException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
  } finally {
    preparedStatement.close();
    dbConnection.close();
  }