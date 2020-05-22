String sql = "Select * from Activity";
Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery( sql );
ResultSetMetaData md = rs.getMetaData();
int columns = md.getColumnCount();

//  Get column names

for (int i = 1; i <= columns; i++)
{
    columnNames.addElement( md.getColumnName(i) );
}

//  Get row data

while (rs.next())
{
    Vector row = new Vector(columns);

    for (int i = 1; i <= columns; i++)
    {
        row.addElement( rs.getObject(i) );
    }

    data.addElement( row );
}