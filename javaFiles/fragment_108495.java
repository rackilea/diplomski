public void createTable(Mbean bean) throws SQLException{
    String sql = getCreateTable(bean);
    // execute SQL using JDBC...
}

private String getCreateTable(Mbean bean) {
    String sqlStart = "CREATE TABLE " + getTableName(bean.getClassName()) + " (" ;
    return bean.getAttributes().stream()
        .map(attribute -> mapToColumn(attribute))
        .collect(Collectors.joining(", ", sqlStart, ")"); // what about primary key?
}

private String mapToColumn(Attribute a) {
    return getColumnName(a.getName()) + " " + getType(/*it depends*/);
}