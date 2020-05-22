String sql = "SELECT * FROM LOGIN where username=? and password=?";

stmt = con.prepareStatement(sql);
// Bind values into the parameters.
stmt.setString(1, user); // This would set username
stmt.setString(2, pass); // This would set password
rs = stmt.executeQuery();
if (rs.next()) {
    pw.println("correct login");
    request.getRequestDispatcher("message.html").include(request, response);
    ...
} else {
    pw.println("please check username/password again.<br>");
    request.getRequestDispatcher("userloginpage.html").include(request, response);
}