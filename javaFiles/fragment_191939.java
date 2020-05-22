Connection c = DriverManager.getConnection (...);
DatabaseMetaData md = c.getMetaData();
ResultSet rs = md.getTables(null, null, "%", null);
while (rs.next()) {
  System.out.println(rs.getString(3));
}