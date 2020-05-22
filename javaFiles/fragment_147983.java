if (resultSet.next()) {
    if (resultSet.getString("password").equals(password)){
        out.println("Login attempt successful!");
        out.println("<br><a href='index.jsp'>Back to Login Page</a>");
    } else {
        out.println("Password incorrect");
        out.println("<br><a href='index.jsp'>Back to Login Page</a>");
    }
} else {
    out.println("User doesn't exist");
    out.println("<br><a href='index.jsp'>Back to Login Page</a>");
}