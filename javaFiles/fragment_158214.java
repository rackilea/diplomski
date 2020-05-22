public void authenticateSession(HttpSession session, UserDetails user) {
    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
            user.getUsername(), user.getPassword());
    UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
            user, authRequest.getCredentials(), user.getAuthorities());
    result.setDetails(authRequest.getDetails());

    SecurityContext ctx = SecurityContextHolder.createEmptyContext();
    ctx.setAuthentication(result);

    session.setAttribute(
            UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_USERNAME_KEY,
            TextEscapeUtils.escapeEntities(user.getUsername()));
    session.setAttribute(
            HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
            ctx);

    AuthenticationSuccessEvent event = new AuthenticationSuccessEvent(
            result);
    applicationContext.publishEvent(event);
}