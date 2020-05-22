String name=rs.getString("name");
 String price=Double.toString(rs.getDouble("price"));
     out.println("<footer class=\"align-center\">");
   //passing value in url
     out.println("<a href=\"Cart?name="+name+"&price="+price\" target=\"_blank\" class=\"button alt\">Open</a>");
      out.println("</footer>");