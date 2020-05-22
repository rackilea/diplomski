@Override
protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
    logger.debug("failed authentication while attempting to access "+ URL_PATH_HELPER.getPathWithinApplication((HttpServletRequest) request));
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.sendRedirect("/");
}