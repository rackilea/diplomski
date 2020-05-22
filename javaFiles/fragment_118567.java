// n variable contains the name
String query = "Select * from users where name= ? and surname = ?";
PreparedStatement prep = connection.prepareStatement(query);
prep.setString(1, n);
prep.setNull(2, Types.VARCHAR);
ResultSet rs = prep.executeQuery();