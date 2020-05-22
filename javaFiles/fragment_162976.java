UserDetails userDetails = userDetailsService.loadUserByUsername(username);
if (tokenHelper.validateToken(authToken, userDetails)) {
    // create authentication
    TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
    authentication.setToken(authToken);
    SecurityContextHolder.getContext().setAuthentication(authentication);
}