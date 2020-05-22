Connection db = DriverManager.getConnection( jdbc:mysql://192.168.0.3:3306,<user>,<password>);
Statement stmt = db.createStatement();
PreparedStatement psmt = con.prepareStatement("SELECT * FROM DB");
ResultSet rs = psmt.executeQuery();

// get column names
int len = rs.getMetaData().getColumnCount();
Vector cols= new Vector(len);
for(int i=1; i<=len; i++) // Note starting at 1
    cols.add(rs.getMetaData().getColumnName(i));


// Add Data
Vector data = new Vector();
while(rs.next())
{
    Vector row; = new Vector(len);
    for(int i=1; i<=len; i++)
    {
        row.add(rs.getString(i));
    }
    data.add(row);
}

// Now create the table
JTable table = new JTable(data, cols);