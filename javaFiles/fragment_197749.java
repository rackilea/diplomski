try {
  Context ctx = new InitialContext();
  DataSource ds = (DataSource) ctx.lookup("jdbc/myDBResource");
  Connection connection = ds.getConnection();
  ...
}
catch (Exception exc) {
  ...
}