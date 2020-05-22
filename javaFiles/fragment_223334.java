String userName = request.getParameter("userName");
String passWord = request.getParameter("password");

String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/";
String dbName = "userdb";
String user = "root"; 
String password = "1234";
String sql = "SELECT * FROM LOGIN WHERE USR_NAME = ? AND USR_PASS = ?"; // Not sure how the password column is named, you need to check/update it. You should leave those ? there! Those are preparedstatement placeholders.

Connection connection = null;
PreparedStatement statement = null;
ResultSet resultSet = null;
boolean login = false;

try {
    Class.forName(driver); // You don't need to call it EVERYTIME btw. Once during application's startup is more than enough.
    connection = DriverManager.getConnection(url + dbName, user, password);
    statement = connection.prepareStatement(sql);
    statement.setString(1, userName);
    statement.setString(2, password);
    resultSet = statement.executeQuery();
    login = resultSet.next();
} catch (Exception e) {
    throw new ServletException("Login failed", e);
} finally {
    if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
    if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
    if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
}

if (login) {
    request.getSession().setAttribute("username", userName); // I'd prefer the User object, which you get from DAO, but ala.
    response.sendRedirect("home.jsp"); // Redirect to home page.
} else {
    request.setAttribute("message", "Unknown username/password, try again"); // This sets the ${message}
    request.getRequestDispatcher("login.jsp").forward(request, response); // Redisplay JSP.
}