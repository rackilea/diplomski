// much easier to read with String.format()... in my opinion
final String updateString = String.format("create table %s (%s %s, %s %s)",
        TABLE_NAME_TBL_IPS,
        TABLE_COLUMN_COMPANY,
        TABLE_COLUMN_COMPANY_DATA_TYPE,
        TABLE_COLUMN_IP,
        TABLE_COLUMN_IP_DATA_TYPE);

Connection con = null;

try {
    con = DriverManager.getConnection("jdbc:derby:yourDatabaseName");

    PreparedStatement ps = con.prepareStatement(updateString);
    ps.executeUpdate();
    ps.close();
}
catch (SQLException e) {
    e.printStackTrace();
}
finally {
    try {
        con.close();
    }
    catch (Exception ignored) {
    }
}