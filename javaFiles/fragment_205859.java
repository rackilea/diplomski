if (uri.matches(".*[css|jpg|png|gif|js|jsp]$")) {
    filterChain.doFilter(req, res);
}else{
    // forward the request to Servlet/JSP/HTML
    req.getRequestDispatcher("path").forward(req, resp);
}