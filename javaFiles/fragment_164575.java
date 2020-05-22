public enum SQLQuery {
  QUERY1("SELECT foo FROM BAR", 0),
  QUERY2("SELECT foo from BAR where baz = ?"; 1);

  private final String sql;
  private final int argumentCount;

  private SQLQuery(final String sql, final int argumentCount) {
    this.sql = sql;
    this.argumentCount = argumentCount;
  }

  public String getSQL() {
    return sql;
  }

  public int getArgumentCount() {
    return argumentCount;
  }
}