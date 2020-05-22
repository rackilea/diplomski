String resultsDatabase = sb.substring(separator.length());
String sql = "UPDATE students SET events = ? WHERE username = ?";
PreparedStatement myStmt = conn.prepareStatement(sql);
myStmt.setString(1, resultsDatabase);
myStmt.setString(2, user_name);
myStmt.executeUpdate();