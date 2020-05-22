HttpServletRequest req = (HttpServletRequest) request;
HttpServletResponse res = (HttpServletResponse) response;
if ("GET".equals(req.getMethod()) && "/b.jsf".equals(req.getServletPath())) {
   res.sendRedirect("a.jsf");
} else {
   chain.doFilter(request, response);
}