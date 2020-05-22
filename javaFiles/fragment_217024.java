String myTable = "FOO_TABLE";
String query = "Select COLUMN_NAME from USER_TAB_COLUMNS where TABLE_NAME=?";
PreparedStatement ps = conn.prepareStatement(query);
ps.setString(1, myTable);
//
Set<String> existingColumns = new HashSet<String>();
ResultSet rs = ps.executeQuery();

while (rs.next())
{
    existingColumns.add(rs.getString(1));
}