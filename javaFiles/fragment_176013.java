String servletPath = request.getServletPath();

if (servletPath.equals("/index")) {
    response.sendRedirect("index.jsp");
}
else if (servletPath.equals("/contactus")) {
    response.sendRedirect("contactus.jsp");
}

// ...