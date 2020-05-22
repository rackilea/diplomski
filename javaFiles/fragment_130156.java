protected void authenticate(UserDTO user){
    SecurityContextHolder.getContext().getAuthentication();
    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
    token.setDetails(new WebAuthenticationDetails(getRequest()));
    Authentication authentication = authenticationManager.authenticate(token);
    SecurityContextHolder.getContext().setAuthentication(authentication);
}