//statement is a global\cached statement
if(statement == null) {
    String sql = "select password from userdata where username=?";
    statement = connection.prepareStatement(sql);
}
statement.setString(1, "John");
ResultSet rs = statement.executeQuery(selectSQL);