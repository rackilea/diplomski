//all these values are supplied by the GUI
int rowsPerPage = 10;
int pageNumber = 3;
String columnToSortBy = "first_name"; //this value should never be directly edited by the user. Otherwise it could be used for sql injection

String selectClause = "select * from users\n";
String whereClause = "where first_name like ?";
String orderClause = "order by " + columnToSortBy + "\n";
String limitClause = "offset ? rows fetch first ? rows only";

//build the sql statement
String statement = "";
statement += selectClause;
statement += whereClause;

//get the total rows
int totalRows = 0;
try (PreparedStatement ps = conn.prepareStatement(statement)) {
   ps.setString(1, "Sam%");

   ResultSet rs = ps.executeQuery();
   while (rs.next()) {
        totalRows++;
   }
}
System.out.println(totalRows + " total rows\n");        

//change the statement to use pagination
statement += orderClause;
statement += limitClause;

//get the 3rd page
try (PreparedStatement ps = conn.prepareStatement(statement)) {

   ps.setString(1, "Sam%");
   ps.setInt(2, pageNumber * rowsPerPage);
   ps.setInt(3, rowsPerPage);

   ResultSet rs = ps.executeQuery();
   printResultSet(rs);
}

System.out.println("\nNext page\n");

//get the 4th page
try (PreparedStatement ps = conn.prepareStatement(statement)) {

   ps.setString(1, "Sam%");
   ps.setInt(2, (pageNumber + 1) * rowsPerPage);
   ps.setInt(3, rowsPerPage);

   ResultSet rs = ps.executeQuery();
   printResultSet(rs);
}