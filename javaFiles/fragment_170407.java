String sql = "Select * from ???";
Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery( sql );
ResultSetMetaData md = rs.getMetaData();
int columns = md.getColumnCount();

//  Get column names

Vector<Object> columnNames = new Vector<Object>();

for (int i = 1; i <= columns; i++)
{
    columnNames.addElement( md.getColumnLabel(i) );
}