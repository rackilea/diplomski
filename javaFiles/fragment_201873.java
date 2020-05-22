String query="insert into browse values('0',?,NOW(),?,?,?)";
PreparedStatement stmt = conn.prepareStatement(query);
stmt.setString(1, name);
stmt.setString(2, article);
stmt.setString(3, unit);
stmt.setString(4, user);
int inserted = stmt.executeUpdate();