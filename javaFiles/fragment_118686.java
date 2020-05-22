boolean isStaticResource = request.getRequestURI().startsWith("/resources/");

if (loggedIn || loginRequest || isMainPage || isStaticResource) { 
    chain.doFilter(request, response);
} else {
    response.sendRedirect(loginURI);
}