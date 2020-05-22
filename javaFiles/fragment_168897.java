public Object getResult(ResultSet rs, String columnName) throws SQLException {
    Object s = rs.getString(columnName);
    if (rs.wasNull()) {
        return null;
    } else {
        return s;
    }
}