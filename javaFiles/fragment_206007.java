String sql = "insert into user values (?, ?, ?, ?, ?, ?)";
PreparedStatement ps = con.prepareStatement(insertTableSQL);
ps.setString(1, email);
ps.setString(2, password);
ps.setString(3, firstName);
ps.setString(4, lastName);
ps.setString(5, dob);
ps.setString(6, accountType);
ps.executeUpdate();