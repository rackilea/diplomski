PreparedStatement stmt = conn.prepareStatement("Select * from employee where userNum=?",
        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
);
stmt.setInt(1, x);

ResultSet rs = stmt.executeQuery();
ResultSetMetaData rsmd = rs.getMetaData();
int numberOfColumns = rsmd.getColumnCount();
List l = new ArrayList();
rs.first();
int rowcount = 0;
do {
    rowcount++;
} while (rs.next());
rs.first();
int rowindex = 0;
Object array2D[][] = new Object[rowcount][];
do {
    array2D[rowindex] = new Object[numberOfColumns];
    for (int i = 0; i < numberOfColumns; i++) {
        array2D[rowindex][i] = rs.getObject(i + 1);
    }
    // prints each row on separate line
    System.out.println("array2D[" + rowindex + "] = " + Arrays.toString(array2D[rowindex])); 
    rowindex++;
} while (rs.next());
System.out.println("array2D = " + Arrays.deepToString(array2D));