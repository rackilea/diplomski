//all these values are supplied by the GUI
int rowsPerPage = 10;
int pageNumber = 3;
String columnToSortBy = "first_name"; //this value should never be directly edited by the user. Otherwise it could be used for sql injection

StringBuilder statement = new StringBuilder();
statement.append("select * from users\n");
statement.append("order by " + columnToSortBy + "\n");
statement.append("offset ? rows fetch first ? rows only");

try (PreparedStatement ps = conn.prepareStatement(statement.toString())) {

   ps.setInt(1, pageNumber * rowsPerPage);
   ps.setInt(2, rowsPerPage);

   ResultSet rs = ps.executeQuery();
   printResultSet(rs);
}