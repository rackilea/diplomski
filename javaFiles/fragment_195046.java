@Override
public void autologin(String username, String password) {
    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

    Authentication auth = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

    if (auth.isAuthenticated()) {
        SecurityContextHolder.getContext().setAuthentication(auth);
        logger.debug(String.format("Auto login %s successfully!", username));
    }
}