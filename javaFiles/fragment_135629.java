HttpServletRequest req = (HttpServletRequest) request;
String path = req.getRequestURI().substring(req.getContextPath().length());

if (path.startsWith("/resources/")) {
    chain.doFilter(request, response);
} else {
    request.getRequestDispatcher("/pages" + path).forward(request, response);
}