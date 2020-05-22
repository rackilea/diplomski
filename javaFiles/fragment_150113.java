String name = "John's Cross";
String sql = "SELECT * FROM Person WHERE name = ?";

PreparedStatement stmt = Hibernate3To4Utils.getConnection(session).prepareStatement(sql);
stmt.setParameter(1, name);
return stmt.executeQuery();