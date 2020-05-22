String URL = "jdbc:oracle:thin:@ip:port:sid";
String USER = "test";
String PASS = "test";
String query = "Select * from mytable";
try {
    Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
    Connection con = DriverManager.getConnection(URL, USER, PASS);
    Statement stmt = con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY);
    ResultSet rs = stmt.executeQuery(query);
    if (rs.next()) {
        rs.last();
        System.out.println("total rows is : " + rs.getRow());
    } else {
        System.out.println("No Data");
    }
} catch (Exception e) {
    e.printStackTrace();
}