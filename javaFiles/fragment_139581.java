public static boolean doesTableExist(Connection con, String tableName) throws SQLException {

    ResultSet rs = null;

    PreparedStatement stm = con.prepareStatement("SELECT * FROM user_objects WHERE object_type = 'TABLE' and object_name=?");
    stm.setString(1,tableName.toUpperCase()); //case sensitive
    rs = stm.executeQuery();
    if(rs.next()) {
        return true;
      }
    return false;
}