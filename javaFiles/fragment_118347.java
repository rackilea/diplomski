public void theQuery()
{
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/yourBDD";
    String sqlLogin = "login";
    String sqlPassword = "password";
    Connection conn = DriverManager.getConnection(url, sqlLogin, sqlPassword);
    String query = " insert into CONFERENCE(CONFERENCEID, NAME, YEAR, COUNTRY, CITY, VENUE, EMAIL) values (?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement preparedStmt = cnx.prepareStatement(query);
    preparedStmt.setString(1, cid.getText());
    preparedStmt.setString(2, cname.getText());
    preparedStmt.setString(3, cyear.getYear());
    preparedStmt.setString(4, csd.getDate());
    preparedStmt.setString(5, ced.getDate());
    preparedStmt.setString(6, country.getText());
    preparedStmt.setString(7, city.getText();
    ...
    preparedStmt.execute();
    conn.close(); 
}