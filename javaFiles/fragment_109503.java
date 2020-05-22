public class StrToIntTypeHandler implements TypeHandler<String> {
  @Override
  public void setParameter(PreparedStatement ps, int i,
      String parameter, JdbcType jdbcType) throws SQLException {
    ps.setInt(i, Integer.parseInt(parameter));
  }
  // other methods are for binding query results.
}