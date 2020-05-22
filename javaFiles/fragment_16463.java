ResultSetMetaData rsmd = rs.getMetaData();
int cols = rsmd.getColumnCount();
//format begins after 20 characters.

String format = "%-20s";

for(int i=1; i<=cols; i++)
    System.out.printf(format, rsmd.getColumnLabel(i));
System.out.println("\n--------------------------------------------------------------");
while(rs.next())
{

    for(int i=1; i<=cols; i++)
        System.out.printf(format, rs.getString(i));

    System.out.println();
}