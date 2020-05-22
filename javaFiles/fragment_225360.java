/* Change the default TimeZone of JVM */
TimeZone.setDefault(TimeZone.getTimeZone("UTC")); 
Calendar c = Calendar.getInstance();
Class.forName("nl.cwi.monetdb.jdbc.MonetDriver");
Connection con = DriverManager.getConnection("jdbc:monetdb://localhost/online", "monetdb", "monetdb");
Statement st = con.createStatement();
ResultSet rs;
rs = st.executeQuery("SELECT * FROM user");
/* In each iteration:
 * 1. set TimeZone to UTC
 * 2. fetch record
 * 3. convert to Asia/Tehran and so on ... */
while (rs.next()) {
    c.setTimeZone(TimeZone.getTimeZone("UTC"));
    c.setTime(rs.getTimestamp("birth_date"));
    System.out.println(c); /* This is original values in the database */
    c.setTimeZone(TimeZone.getTimeZone("Asia/Tehran"));
    System.out.println(c); /* This is the values I'm looking for */
}