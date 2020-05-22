@Override
protected void successfulAuthentication(HttpServletRequest req,
        HttpServletResponse res, FilterChain chain, Authentication auth) {
    TokenAuthenticationService.addAuthentication(res, auth.getName());
    chain.doFilter(req, res);
}