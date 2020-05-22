if (httpServletRequest.getRequestURI().endsWith(".png")) {
    chain.doFilter(request, response);
}
else {
    request.getRequestDispatcher("/app" + httpServletRequest.getRequestURI()).forward(request, response);
}