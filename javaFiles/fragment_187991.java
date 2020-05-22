public void doManualLogin(HttpServletRequest request, String u, String p) {
    UsernamePasswordAuthenticationToken token = 
            new UsernamePasswordAuthenticationToken(u, p);
    token.setDetails(new WebAuthenticationDetails(request));
    Authentication auth = authenticationProvider.authenticate(token);
    SecurityContextHolder.getContext().setAuthentication(auth);
}