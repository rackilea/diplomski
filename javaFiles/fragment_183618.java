String requestURI = ((HttpServletRequest) request).getRequestURI();
String forwardURI = (String) request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI);
String includeURI = (String) request.getAttribute(RequestDispatcher.INCLUDE_REQUEST_URI);

if (includeURI != null) {
    System.out.println("JSP included: " + includeURI);
} else if (forwardURI != null) {
    System.out.println("JSP forwarded: " + requestURI); // No, not forwardURI!
} else {
    System.out.println("JSP requested: " + requestURI);
}

chain.doFilter(request, response);