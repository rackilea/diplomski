ResultSetMetaData rsmd = rs.getMetaData();
pw.println("<table border=1>");
pw.println("<tr>");
for (int i = 1 ; i <= rsmd.getColumnCount() ; i++) {
    pw.println("<th>" + rsmd.getColumnName(i) + "</th>");
}
pw.println("</tr>");
while (rs.next()) {
    pw.println("<tr><td>" + rs.getInt(1) + "</td>" + "<td>" + rs.getString(2) + "</td>" + "<td>" + rs.getString(3)
            + "</td></tr>");
}
pw.println("</table>");