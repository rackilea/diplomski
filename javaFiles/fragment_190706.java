String loginURL = httpRequest.getContextPath() + "/login.jsp";

if (httpRequest.getRequestURI().equals(loginURL)) || session.getAttribute("userName") != null) {
    chain.doFilter(request, response);
} else {
    httpResponse.sendRedirect(loginURL);
}