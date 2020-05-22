String query = "INSERT INTO andre(username,password) VALUES(?, ?)";
//PreparedStatement supports parameters, Statement doesn't
PreparedStatement stmt = con.prepareStatement(query);
stmt.setString(1, username);
stmt.setString(2, password);
stmt.executeUpdate();
//check the order of execution
stmt.close();
con.close();