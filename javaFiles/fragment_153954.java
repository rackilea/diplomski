[...]
  public T getResult(ResultSet rs, String columnName) throws SQLException {
    T result = getNullableResult(rs, columnName);
    if (rs.wasNull()) {
      return null;
    } else {
      return result;
    }
  }

  public T getResult(ResultSet rs, int columnIndex) throws SQLException {
    T result = getNullableResult(rs, columnIndex);
    if (rs.wasNull()) {
      return null;
    } else {
      return result;
    }
  }

  public T getResult(CallableStatement cs, int columnIndex) throws SQLException {
    T result = getNullableResult(cs, columnIndex);
    if (cs.wasNull()) {
      return null;
    } else {
      return result;
    }
  }

  public abstract void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

  public abstract T getNullableResult(ResultSet rs, String columnName) throws SQLException;

  public abstract T getNullableResult(ResultSet rs, int columnIndex) throws SQLException;

  public abstract T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException;
[...]