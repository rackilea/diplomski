private int localVisits = -1;

String sqlRead = "SELECT visits FROM visitsTable WHERE id = 1;";
String sqlUpdate = "UPDATE visitsTable SET visits=visits+1 WHERE id = 1;";
Connection con;

protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection
        ("jdbc:mysql://XXX.XXX.XXX.XXX:PPPP/dbName", "user", "pass");
    } catch (Exception e) {}

//calling write new visitor to db function
    writeDBCounter();

//reading from db to send to frontend
    String report = "-2";
    try {
        report = "" + readDBCounter();
    } catch (SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
    response.setContentType("application/json");
    response.getWriter().write(report);
//closing connection
try {
    con.close();
} catch (SQLException e) {
    e.printStackTrace();
}

}

// read
private synchronized int readDBCounter() throws SQLException {
    int newVisits = -1;
    ResultSet rs = null;
    try {
        java.sql.Statement s =con.createStatement();
        s.executeQuery(sqlRead);
         rs = s.getResultSet();
        rs.next();
        newVisits = rs.getInt("visits");


    } catch (Exception ex) {
        System.out.print(ex);
    }
    rs.close();
    return newVisits;
}

// write
private synchronized void writeDBCounter() {
    try {
        PreparedStatement preparedStmt = con.prepareStatement(sqlUpdate);
        preparedStmt.executeUpdate();
    } catch (Exception ex) {
    }
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
}