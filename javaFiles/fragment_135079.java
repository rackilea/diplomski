if (!request.getRequestURI().contains("/api/v1/account/import")) {
    final JJWTService jjwtService = new JJWTService();

    if (token == null || !jjwtService.parseJWTToken(token)) {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    } else {
        filterChain.doFilter(req, res);
    }
}