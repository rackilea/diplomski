Connection con = null;
PreparedStatement st = null;
ResultSet rs = null;
String sql = "select name,author,publisher,price from book where "
    + "type=?";

try {
  // Class.forName(drivername); // <-- not needed since JDBC Version 4
  // http://stackoverflow.com/a/8053125/2970947
  con = DriverManager.getConnection(url, username,
      password);
  st = con.prepareStatement(sql);
  st.setString(1, booktype);

  System.out.println(sql);
  rs = st.executeQuery();
  out.println("<html><body><table border=5>");
  out.println("<tr><th>name</th>");
  out.println("<th>author</th>");
  out.println("<th>publisher</th>");
  out.println("<th>price</th></tr><tr>");
  while (rs.next()) {
    String name = rs.getString("name");
    String author = rs.getString("author");
    String publisher = rs.getString("publisher");
    String price = rs.getString("price");

    out.println("<td>" + name + "</td>");
    out.println("<td>" + author + "</td>");
    out.println("<td>" + publisher + "</td>");
    out.println("<td>" + price + "</td>");
  }
  out.println("</tr></table></body></html");
} catch (ClassNotFoundException cnfe) {
  System.out.println("Exception caught : " + cnfe);
} catch (SQLException se) {
  System.out.println("Exception caught : " + se);
} finally {
  try {
    rs.close();
  } catch (SQLException se1) {
    System.out
        .println("Exception caught : " + se1);
  }
  try {
    st.close();
  } catch (SQLException se1) {
    System.out
        .println("Exception caught : " + se1);
  }
  try {
    con.close();
  } catch (SQLException se1) {
    System.out
        .println("Exception caught : " + se1);
  }
}