if (rs.isBeforefirst()) {
   // do the stuff for logged in user
   response.sendRedirect("index.jsp");
} else {
   response.sendRedirect("invalid.jsp");
}