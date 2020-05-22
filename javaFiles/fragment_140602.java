out.println("<form method=\"get\" action=\"/datainsert/DataInsertTable\">"); //added line
out.println("<tr>");
while (rs.next())   {
  ...//you get the idea
}
out.println("</form>"); //added line